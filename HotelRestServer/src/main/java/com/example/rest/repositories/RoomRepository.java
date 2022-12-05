package com.example.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.models.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
