package com.example.rest.models;

public class Client {

	/* ATTRIBUTES */
	private int id;
	private String name;
	private String surname;
	private String card;
	private String date;
	private String cvv;

	public Client() {
	}

	public Client(String name, String surname, String card, String date, String cvv) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.card = card;
		this.date = date;
		this.cvv = cvv;
	}

	/* METHODS */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", surname=" + surname + ", card=" + card + ", date=" + date
				+ ", cvv=" + cvv + "]";
	}

}
