package com.example.rest.models;

import java.time.LocalDate;

public class Booking {

	private long id;

	private long idBooking;

	private Room room;

	private Hotel hotel;

	private LocalDate start;

	private LocalDate end;

	public Booking() {
	}

	public Booking(Long idBooking, Hotel hotel, Room room, LocalDate start, LocalDate end) {
		this.idBooking = idBooking;
		this.hotel = hotel;
		this.room = room;
		this.start = start;
		this.end = end;
	}

	public long getIdBooking() {
		return idBooking;
	}

	public void setIdBooking(long idBooking) {
		this.idBooking = idBooking;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", room=" + room + ", hotel=" + hotel + ", start=" + start + ", end=" + end + "]";
	}

}
