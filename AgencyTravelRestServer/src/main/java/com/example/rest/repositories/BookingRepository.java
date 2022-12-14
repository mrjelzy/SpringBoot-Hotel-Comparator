package com.example.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
