package com.example.rest.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Offer {
	@Id
	@GeneratedValue
	private long id;
	private double price;
	private LocalDate start;
	private LocalDate end;
	
    @ManyToOne
    private Hotel hotel;
    
    @ManyToOne
    private Agency agency;
    
    @ManyToOne
    private Room room;

    public Offer() {}
	public Offer(double price, LocalDate start, LocalDate end, Hotel hotel, Agency agency, Room room) {
		this.price = price;
		this.start = start;
		this.end = end;
		this.hotel = hotel;
		this.agency = agency;
		this.room = room;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
}
