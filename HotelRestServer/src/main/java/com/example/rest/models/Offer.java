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
	private LocalDate start;
	private LocalDate end;
	private double discount;
	
    @ManyToOne
    private Hotel hotel;
    
    @ManyToOne
    private Agency agency;
    
    @ManyToOne
    private Room room;

    public Offer() {}
	public Offer(LocalDate start, LocalDate end, Hotel hotel, Agency agency, Room room, double discount) {
		this.start = start;
		this.end = end;
		this.hotel = hotel;
		this.agency = agency;
		this.room = room;
		this.discount = discount;
	}


	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
