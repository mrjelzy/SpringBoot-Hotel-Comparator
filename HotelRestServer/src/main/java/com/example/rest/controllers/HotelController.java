package com.example.rest.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.example.rest.models.Partnership;
import com.example.rest.models.Room;
import com.example.rest.repositories.AgencyRepository;
import com.example.rest.repositories.BookingRepository;
import com.example.rest.repositories.ClientRepository;
import com.example.rest.repositories.HotelRepository;
import com.example.rest.repositories.PartnershipRepository;
import com.example.rest.repositories.RoomRepository;



@RestController
public class HotelController {

	/* ATTRIBUTES */
	@Autowired
	private HotelRepository repository;
	@Autowired
	private AgencyRepository aRepository;
	@Autowired
	private PartnershipRepository pRepository;
	@Autowired
	private BookingRepository bRepository;
	@Autowired
	private RoomRepository rRepository;
	@Autowired
	private ClientRepository cRepository;
	private static final String uri = "hotelservice/api";

	
	/* METHODS */
	
	@GetMapping(uri + "/partner/{id}")
	public Partnership getPartnerById(@PathVariable long id) {
		return pRepository.findById(id).get();
	}
	
	@GetMapping(uri + "/hotels")
	public List<Hotel> getAllHotels() {
		return repository.findAll();
	}
	
	@GetMapping(uri + "/bookings")
	public List<Booking> getAllBookings() {
		return bRepository.findAll();
	}

	@GetMapping(uri + "/hotels/{id}")
	public Hotel getHotelById(@PathVariable long id) throws HotelNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new HotelNotFoundException(
						"Error : Could not fint hotel with id : " + id));
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri + "/hotels")
	public Hotel createHotel(@RequestBody Hotel hotel) {
		return repository.save(hotel);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri + "/offers")
	public List<Offer> getOffers(@RequestBody InputOffer input) throws AgencyNotFoundException {
		if(!aRepository.findByLoginAndPassword(input.getaName(), input.getaPassword()).isPresent())
			throw new AgencyNotFoundException("Agence non reconnu");
		Agency connected = aRepository.findByLoginAndPassword(input.getaName(), input.getaPassword()).get();
		List<Room> rooms = rRepository.findByNbPeoplesGreaterThanEqual(input.getNbPeoples());
		List<Room> freeRooms = bRepository.findRoomsByFreeDates(input.getEnd(), input.getStart());
		List<Room> availableRooms = new ArrayList<Room>();
		for(Room r : freeRooms) {
			if(rooms.contains(r))
				availableRooms.add(r);
		}
		List<Offer> offers = new ArrayList<Offer>();
		for(Room r : availableRooms) {
			/*
			 * double price = r.getPrice() Offer o = new Offer(LocalDate start, LocalDate
			 * end, Hotel hotel, Agency agency, Room room, double price)
			 */
		}
		return null;
	}
	
	/*
	 * @PostMapping(uri + "/offers") public List<Offer> getOffers(@RequestBody ) {
	 * return null; }
	 */

	@PutMapping(uri + "/hotels/{id}")
	public Hotel updateHotel(@RequestBody Hotel newHotel, @PathVariable long id) {
		return repository.findById(id).map(hotel -> {
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

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(uri + "/hotels/{id}")
	public void deleteHotel(@PathVariable long id) throws HotelNotFoundException {
		Hotel hotel = repository.findById(id)
				.orElseThrow(() -> new HotelNotFoundException("Error : Could not fint employee with id : " + id));
		repository.delete(hotel);
	}

}
