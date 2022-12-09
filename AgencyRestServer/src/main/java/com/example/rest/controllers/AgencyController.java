package com.example.rest.controllers;

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

import com.example.rest.comparator.OutputBooking;
import com.example.rest.comparator.InputBooking;
import com.example.rest.comparator.InputSearch;
import com.example.rest.comparator.OutputSearch;
import com.example.rest.exceptions.AgencyNotFoundException;
import com.example.rest.models.Agency;
import com.example.rest.models.Hotel;
import com.example.rest.models.Offer;
import com.example.rest.repositories.AgencyRepository;
import com.example.rest.repositories.HotelRepository;
import com.example.rest.repositories.OfferRepository;

@RestController
public class AgencyController {

	/* ATTRIBUTES */
	@Autowired
	private AgencyRepository aRepository;

	@Autowired
	private HotelRepository hRepository;

	@Autowired
	private OfferRepository oRepository;

	private static final String uri = "agencyservice/api";

	/* METHODS */
	@GetMapping(uri + "/agencies")
	public List<Agency> getAllAgencys() {
		return aRepository.findAll();
	}

	@PutMapping(uri + "/agencies/{id}")
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

	@PostMapping(uri + "/agencies/sendSearch")
	public List<Offer> sendSearch(@RequestBody InputSearch input) {
		RestTemplate restTemplate = new RestTemplate();

		String city = input.getCity();
		String country = input.getCountry();

		List<Hotel> hotel = hRepository.findByCityAndCountry(input.getCity(), input.getCountry());
		Agency agency = aRepository.findById(1L).get();

		OutputSearch output = new OutputSearch(agency.getLogin(), agency.getPassword(), input.getStart(),
				input.getEnd(), input.getNbPeople());
		List<Offer> offers = new ArrayList<Offer>();
		
		for (Hotel h : hotel) {
			Long idH = h.getId();
			Offer[] offer = restTemplate.postForObject("http://localhost:8080/hotelservice/" + idH + "/api/offers",
					output, Offer[].class);
			for (Offer o : offer)
				o.setHotel(h);
			offers.addAll(Arrays.asList(offer));
		}
		for (Offer o : offers) {
			o.setIdOffer(o.getId());
			oRepository.save(o);
		}
		return offers;
	}

	@PostMapping(uri + "/agencies/sendChoice")
	public Long sendChoice(@RequestBody InputBooking input) {
		RestTemplate restTemplate = new RestTemplate();

		Offer offer = oRepository.findById(input.getIdOffer()).get();
		Agency agency = aRepository.findById(1L).get();
		OutputBooking output = new OutputBooking(agency.getLogin(), agency.getPassword(), input.getIdOffer(),
				input.getName(), input.getSurname(), input.getCard(), input.getCvv(), input.getExp());

		Long idH = offer.getHotel().getId();

		Long idBooking = restTemplate.postForObject("http://localhost:8080/hotelservice/" + idH + "/api/book", output,
				Long.class);

		return idBooking;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri + "/addhotel")
	public Hotel createHotel(@RequestBody Hotel hotel) {
		return hRepository.save(hotel);
	}

	@PutMapping(uri + "/addhotel/{id}")
	public Hotel updateEmployee(@RequestBody Hotel newHotel, @PathVariable long id) {
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
