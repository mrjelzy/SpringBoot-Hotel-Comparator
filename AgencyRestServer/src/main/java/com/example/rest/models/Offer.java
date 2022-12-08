package com.example.rest.models;

import java.time.LocalDate;

import jakarta.persistence.Id;

public class Offer {
	
	@Id
	private long id;
	private double price;
	private LocalDate start;
	private LocalDate end;
	private Hotel  hotel;
	
	public Offer() {
	}

	public Offer(double price, LocalDate start, LocalDate end, Hotel hotel) {
		this.price = price;
		this.start = start;
		this.end = end;
		this.hotel = hotel;
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

	@Override
	public String toString() {
		return "Offer [id=" + id + ", price=" + price + ", start=" + start + ", end=" + end + ", hotel=" + hotel + "]";
	}
	
	
	
	
}
