package com.example.rest.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Offer {

	private long id;
	private long idOffer;
	private LocalDate start;
	private LocalDate end;
	private double discount;

	private Hotel hotel;

	private Agency agency;

	private Room room;

	public Offer() {
	}

	public Offer(double discount, long idOffer, LocalDate start, LocalDate end, Hotel hotel, Room room, Agency agency) {
		this.discount = discount;
		this.idOffer = idOffer;
		this.start = start;
		this.end = end;
		this.hotel = hotel;
		this.room = room;
		this.agency = agency;
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

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	@Override
	public String toString() {

		double gaps = Math.abs(ChronoUnit.DAYS.between(start, end));
		double totalPrice = room.getPrice() * gaps * (1 - discount);
		if (this.agency == null) {
			return " -Hotel " + hotel.getName() + " " + hotel.getNbStars() + " étoiles, situé au " + hotel.getAdress()
					+ " " + hotel.getCity() + " " + hotel.getCountry() + ". Chambre n° " + room.getId()
					+ ". Prix total du sejour : " + totalPrice + "$. Pour visualiser la chambre cliquez sur ce lien: "
					+ room.getUrlImg();
		} else {
			return " Offre proposée par l'agence " + agency.getName() + ". Hotel " + hotel.getName() + " "
					+ hotel.getNbStars() + " étoiles, situé au " + hotel.getAdress() + " " + hotel.getCity() + " "
					+ hotel.getCountry() + ". Chambre n° " + room.getId() + ". Prix total du sejour : " + totalPrice
					+ "$. Pour visualiser la chambre cliquez sur ce lien: " + room.getUrlImg();
		}
	}

}
