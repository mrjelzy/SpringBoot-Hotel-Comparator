package com.example.rest.comparator;

public class InputBooking {

	/* ATTRIBUTES */
	private long idOffer;
	private String name;
	private String surname;
	private String card;
	private String cvv;
	private String exp;

	public InputBooking() {
	}

	public InputBooking(long idOffer, String name, String surname, String card, String cvv, String exp) {
		this.idOffer = idOffer;
		this.name = name;
		this.surname = surname;
		this.card = card;
		this.cvv = cvv;
		this.exp = exp;
	}

	public long getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(long idOffer) {
		this.idOffer = idOffer;
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

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

}