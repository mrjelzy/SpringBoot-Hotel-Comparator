package com.example.rest.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.rest.models.Booking;
import com.example.rest.models.Room;

public interface BookingRepository extends JpaRepository<Booking, Long>{
	
	@Query("SELECT r from Room r where r NOT IN (select b.room from Booking b where b.end > ?1 AND  b.start < ?2) AND r.nbPeoples >= ?3")
	List<Room> findRoomsByFreeDates(LocalDate start, LocalDate end, int nbPeoples);
}
