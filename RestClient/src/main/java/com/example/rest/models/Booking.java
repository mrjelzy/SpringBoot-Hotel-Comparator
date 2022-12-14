package com.example.rest.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Booking {

	private long id;

	private long idBooking;

	private Room room;

	private Hotel hotel;

	private LocalDate start;

	private LocalDate end;

	private String name;

	private String surname;

	public Booking() {
	}

	public Booking(Long idBooking, Hotel hotel, Room room, LocalDate start, LocalDate end, String name,
			String surname) {
		this.idBooking = idBooking;
		this.hotel = hotel;
		this.room = room;
		this.start = start;
		this.end = end;
		this.name = name;
		this.surname = surname;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		System.out.println("Reservation Confirmée pour ");
		return "N° de la réservation : " + idBooking + ". Hotel " + hotel.getName() + " de " + hotel.getNbStars()
				+ " étoiles, situé au " + hotel.getAdress() + ", " + hotel.getCity() + ", " + hotel.getCountry()
				+ ". Chambre n° " + room.getId();
	}

}
