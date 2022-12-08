package com.example.rest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class Hotel {
	
	@Id
	private long id;
	private String name;
	private String adress;
	private String city;
	private String country;
	private int nbStars;
	
}
