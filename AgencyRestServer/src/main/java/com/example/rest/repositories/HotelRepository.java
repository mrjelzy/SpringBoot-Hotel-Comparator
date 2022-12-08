package com.example.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
	
	List<Hotel> findByCityAndCountry(String city, String country);
	
}
