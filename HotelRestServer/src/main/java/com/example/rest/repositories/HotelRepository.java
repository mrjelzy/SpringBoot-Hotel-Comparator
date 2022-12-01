package com.example.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
