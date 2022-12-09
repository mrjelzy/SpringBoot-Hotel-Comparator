package com.example.rest.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Offer {

	@Id
	@GeneratedValue
	private long id;
	private long idOffer;
	@Column(name = "startDate")
	private LocalDate start;
	@Column(name = "endDate")
	private LocalDate end;
	private double discount;

	@ManyToOne
	@JoinColumn(name = "hotel_id", referencedColumnName = "id")
	private Hotel hotel;

	@OneToOne
	private Room room;

	public Offer() {
	}

	public Offer(double discount, long idOffer, LocalDate start, LocalDate end, Hotel hotel, Room room) {
		this.discount = discount;
		this.idOffer = idOffer;
		this.start = start;
		this.end = end;
		this.hotel = hotel;
		this.room = room;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
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
		return "Offer [id=" + id + ", idOffer=" + idOffer + ", start=" + start + ", end=" + end + ", discount="
				+ discount + ", hotel=" + hotel + ", room=" + room + "]";
	}

}
