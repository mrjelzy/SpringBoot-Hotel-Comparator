package com.example.rest.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Hotel {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String adress;
	private String city;
	private String country;
	private int nbStars;
	
	@JsonIgnore
	private String apiUrl;
	
	@OneToMany(mappedBy="hotel")
	private List<Offer> offers;
	
	public Hotel() {
	}

	public Hotel(long id, String name, String adress, String city, String country, int nbStars, String apiUrl) {
		this.id=id;
		this.name = name;
		this.adress = adress;
		this.city = city;
		this.country = country;
		this.nbStars = nbStars;
		this.apiUrl = apiUrl;
	}

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

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	
}
