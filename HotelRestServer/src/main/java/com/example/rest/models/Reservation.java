package com.example.rest.models;

import java.time.LocalDate;

public class Reservation {

	/* ATTRIBUTES */
	private int id;
	private Hotel hotel;
	private Room room;
	private Client client;
	private LocalDate startDate;
	private LocalDate endDate;

	public Reservation(int id, Hotel hotel, Room room, Client client, LocalDate startDate, LocalDate endDate) {
		this.id = id;
		this.hotel = hotel;
		this.room = room;
		this.client = client;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hotel getHotel() {
		return hotel;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", hotel=" + hotel + ", room=" + room + ", client=" + client + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
	
	

}
