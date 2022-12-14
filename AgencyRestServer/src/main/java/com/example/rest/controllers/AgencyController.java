package com.example.rest.controllers;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.rest.comparator.InputBooking;
import com.example.rest.comparator.InputSearch;
import com.example.rest.comparator.OutputBooking;
import com.example.rest.comparator.OutputSearch;
import com.example.rest.exceptions.AgencyNotFoundException;
import com.example.rest.models.Agency;
import com.example.rest.models.Booking;
import com.example.rest.models.Hotel;
import com.example.rest.models.Offer;
import com.example.rest.repositories.AgencyRepository;
import com.example.rest.repositories.BookingRepository;
import com.example.rest.repositories.HotelRepository;
import com.example.rest.repositories.OfferRepository;
import com.example.rest.repositories.RoomRepository;

@RestController
public class AgencyController {

	/* ATTRIBUTES */
	@Autowired
	private AgencyRepository aRepository;

	@Autowired
	private HotelRepository hRepository;

	@Autowired
	private OfferRepository oRepository;

	@Autowired
	private RoomRepository rRepository;

	@Autowired
	private BookingRepository bRepository;

	private static final String uri = "agencyservice/tour/api";

	/* METHODS */
	@GetMapping(uri + "/agency")
	public Agency getAgency() {
		return aRepository.findAll().get(0);
	}

	@PutMapping(uri + "/agency/{id}")
	public Agency updateAgency(@RequestBody Agency newAgency, @PathVariable long id) throws AgencyNotFoundException {
		return aRepository.findById(id).map(agency -> {
			agency.setName(newAgency.getName());
			agency.setLogin(newAgency.getLogin());
			agency.setPassword(newAgency.getPassword());
			agency.setDiscount(newAgency.getDiscount());
			aRepository.save(agency);
			return agency;
		}).orElseThrow(() -> new AgencyNotFoundException("Error : Could not fint agency with id : " + id));
	}

	@PostMapping(uri + "/sendSearch")
	public List<Offer> sendSearch(@RequestBody InputSearch input) {
		RestTemplate restTemplate = new RestTemplate();

		double gaps = Math.abs(ChronoUnit.DAYS.between(input.getStart(), input.getEnd()));

		List<Hotel> hotel = hRepository.findByCityAndCountryAndNbStars(input.getCity(), input.getCountry(),
				input.getNbStars());
		Agency agency = aRepository.findById(1L).get();

		OutputSearch output = new OutputSearch(agency.getLogin(), agency.getPassword(), input.getStart(),
				input.getEnd(), input.getNbPeople()	);
		List<Offer> offers = new ArrayList<Offer>();

		for (Hotel h : hotel) {
			Offer[] offer = restTemplate.postForObject(h.getApiUrl() + "/api/offers", output, Offer[].class);
			for (Offer o : offer)
				o.setHotel(h);
			offers.addAll(Arrays.asList(offer));
		}

		for (Offer o : offers) {
			o.setIdOffer(o.getId());
			rRepository.save(o.getRoom());
			oRepository.save(o);
			o.setId((oRepository.findByIdOfferAndHotel(o.getIdOffer(), o.getHotel())).getId());
		}
		return offers;
	}

	@PostMapping(uri + "/sendChoice")
	public Booking sendChoice(@RequestBody InputBooking input) {
		RestTemplate restTemplate = new RestTemplate();

		Offer offer = oRepository.findById(input.getIdOffer()).get();

		Agency agency = aRepository.findById(1L).get();
		OutputBooking output = new OutputBooking(agency.getLogin(), agency.getPassword(), offer.getIdOffer(),
				input.getName(), input.getSurname(), input.getCard(), input.getCvv(), input.getExp());

		Hotel hotel = offer.getHotel();

		Long idBooking = restTemplate.postForObject(hotel.getApiUrl() + "/api/book", output, Long.class);

		Booking booked = new Booking(idBooking, hotel, offer.getRoom(), offer.getStart(), offer.getEnd());

		bRepository.save(booked);

		return booked;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri + "/addhotel")
	public Hotel createHotel(@RequestBody Hotel hotel) {
		return hRepository.save(hotel);
	}

	@PutMapping(uri + "/addhotel/{id}")
	public Hotel updateHotel(@RequestBody Hotel newHotel, @PathVariable long id) {
		return hRepository.findById(id).map(hotel -> {
			hotel.setId(newHotel.getId());
			hotel.setName(newHotel.getName());
			hotel.setAdress(newHotel.getAdress());
			hotel.setCity(newHotel.getCity());
			hotel.setCountry(newHotel.getCountry());
			hotel.setNbStars(newHotel.getNbStars());
			return hotel;
		}).orElseGet(() -> {
			newHotel.setId(id);
			hRepository.save(newHotel);
			return newHotel;
		});
	}

}
