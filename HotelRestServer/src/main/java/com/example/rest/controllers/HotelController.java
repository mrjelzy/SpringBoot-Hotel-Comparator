package com.example.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.agency.InputOffer;
import com.example.rest.exceptions.AgencyNotFoundException;
import com.example.rest.exceptions.HotelNotFoundException;
import com.example.rest.models.Agency;
import com.example.rest.models.Booking;
import com.example.rest.models.Hotel;
import com.example.rest.models.Offer;
import com.example.rest.models.Room;
import com.example.rest.repositories.AgencyRepository;
import com.example.rest.repositories.BookingRepository;
import com.example.rest.repositories.ClientRepository;
import com.example.rest.repositories.HotelRepository;
import com.example.rest.repositories.OfferRepository;
import com.example.rest.repositories.RoomRepository;

@RestController
public class HotelController {

	/* ATTRIBUTES */
	@Autowired
	private HotelRepository repository;
	@Autowired
	private AgencyRepository aRepository;
	@Autowired
	private BookingRepository bRepository;
	@Autowired
	private RoomRepository rRepository;
	@Autowired
	private ClientRepository cRepository;
	@Autowired
	private OfferRepository oRepository;
	private static final String uri = "hotelservice/api";

	
	/* METHODS */
		
	@GetMapping(uri + "/bookings")
	public List<Booking> getAllBookings() {
		return bRepository.findAll();
	}

	@GetMapping(uri + "/hotel")
	public Hotel getHotelById(@PathVariable long id) throws HotelNotFoundException {
		return repository.findById(1L)
				.orElseThrow(() -> new HotelNotFoundException(
						"Error : Could not fint hotel with id : " + id));
	}


	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping(uri + "/offers")
	public List<Offer> getOffers(@RequestBody InputOffer input) throws AgencyNotFoundException {
		if(!aRepository.findByLoginAndPassword(input.getLogin(), input.getPassword()).isPresent())
			throw new AgencyNotFoundException("Agence non reconnu");
		Agency connected = aRepository.findByLoginAndPassword(input.getLogin(), input.getPassword()).get();
		List<Room> availableRooms = bRepository.findRoomsByFreeDates(input.getStart(), input.getEnd(), input.getNbPeoples());
		Hotel h = repository.findById(1L).get();
		List<Offer> offers = new ArrayList<Offer>();
		for(Room r : availableRooms) {
			System.out.println(r);
			Offer o = new Offer(input.getStart(), input.getEnd(), h, connected, r, connected.getDiscount());
			offers.add(o);
			oRepository.save(o);
		}
		return offers;
	}
	
	@PutMapping(uri + "/hotel")
	public Hotel updateHotel(@RequestBody Hotel newHotel, @PathVariable long id) {
		return repository.findById(1L).map(hotel -> {
			hotel.setName(newHotel.getName());
			hotel.setAdress(newHotel.getAdress());
			hotel.setCity(newHotel.getCity());
			hotel.setCountry(newHotel.getCountry());
			hotel.setNbStars(newHotel.getNbStars());
			repository.save(hotel);
			return hotel;
		}).orElseGet(() -> {
			newHotel.setId(id);
			repository.save(newHotel);
			return newHotel;
		});
	}

}
