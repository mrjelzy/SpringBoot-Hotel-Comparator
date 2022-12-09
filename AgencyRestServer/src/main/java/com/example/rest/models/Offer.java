package com.example.rest.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Offer {

	@Id
	@GeneratedValue
	private long id;
	private double price;
	private long idOffer;
	@Column(name="startDate") 
	private LocalDate start;
	@Column(name="endDate") 
	private LocalDate end;

	@ManyToOne
	@JoinColumn(name = "hotel_id", referencedColumnName = "id")
	private Hotel hotel;

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
	
	public long getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(long idOffer) {
		this.idOffer = idOffer;
	}
	
	@Override
	public String toString() {
		return "Offer [id=" + id + ", price=" + price + ", start=" + start + ", end=" + end + ", hotel=" + hotel + "]";
	}

}
