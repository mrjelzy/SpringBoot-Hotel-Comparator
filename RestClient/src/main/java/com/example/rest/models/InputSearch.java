package com.example.rest.models;

import java.time.LocalDate;

public class InputSearch {

	/* ATTRIBUTES */
	String city;
	String country;
	private LocalDate start;
	private LocalDate end;
	private int nbPeople;
	private double maxPrice;
	private int nbStars;

	public InputSearch() {
	}

	public InputSearch(String city, String country, LocalDate start, LocalDate end, int nbPeople, int nbStars,
			double maxPrice) {
		this.city = city;
		this.country = country;
		this.start = start;
		this.end = end;
		this.nbPeople = nbPeople;
		this.nbStars = nbStars;
		this.maxPrice = maxPrice;
	}

	/* METHODS */
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public int getNbPeople() {
		return nbPeople;
	}

	public void setNbPeople(int nbPeople) {
		this.nbPeople = nbPeople;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getNbStars() {
		return nbStars;
	}

	public void setNbStars(int nbStars) {
		this.nbStars = nbStars;
	}

}
