package com.example.rest.controllers;

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

import com.example.rest.exceptions.HotelNotFoundException;
import com.example.rest.models.Hotel;
import com.example.rest.repositories.HotelRepository;

@RestController
public class HotelController {

	/* ATTRIBUTES */
	@Autowired
	private HotelRepository repository;
	private static final String uri = "hotelservice/api";

	/* METHODS */
	@GetMapping(uri + "/hotels")
	public List<Hotel> getAllHotels() {
		return repository.findAll();
	}

	@GetMapping(uri + "/hotels/count")
	public String count() {
		return String.format("{\"%s\" : %s}", "count", repository.count());
	}

	@GetMapping(uri + "/hotels/{id}")
	public Hotel getEmployeeById(@PathVariable long id) throws HotelNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new HotelNotFoundException("Error : Could not fint employee with id : " + id));
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri + "/hotels")
	public Hotel createHotel(@RequestBody Hotel hotel) {
		return repository.save(hotel);
	}

	@PutMapping(uri + "/hotels/{id}")
	public Hotel updateEmployee(@RequestBody Hotel newHotel, @PathVariable long id) {
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
	public void deleteEmployee(@PathVariable long id) throws HotelNotFoundException {
		Hotel hotel = repository.findById(id)
				.orElseThrow(() -> new HotelNotFoundException("Error : Could not fint employee with id : " + id));
		repository.delete(hotel);
	}

}
