package com.example.rest.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hotel {

	/* ATTRIBUTES */
	private long id;
	private String name;
	private String adress;
	private String city;
	private String country;
	private int nbStars;

	public Hotel() {
	}

	public Hotel(String name, String adress, String city, String country, int nbStars) {
		this.name = name;
		this.adress = adress;
		this.city = city;
		this.country = country;
		this.nbStars = nbStars;
	}

	/* METHODS */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

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

	public int getNbStars() {
		return nbStars;
	}

	public void setNbStars(int nbStars) {
		this.nbStars = nbStars;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adress, city, country, id, name, nbStars);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return Objects.equals(adress, other.adress) && Objects.equals(city, other.city)
				&& Objects.equals(country, other.country) && id == other.id && Objects.equals(name, other.name)
				&& nbStars == other.nbStars;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", adress=" + adress + ", city=" + city + ", country=" + country
				+ ", nbStars=" + nbStars + "]";
	}

}
