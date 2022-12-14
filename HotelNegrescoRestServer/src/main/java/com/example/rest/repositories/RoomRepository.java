package com.example.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.models.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
	
	  List<Room> findByNbPeoplesGreaterThanEqual(int nbPeoples);
}
