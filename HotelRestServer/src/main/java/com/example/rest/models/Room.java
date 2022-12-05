package com.example.rest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Room {
	@Id
	@GeneratedValue
	private long id;
	private int nbPeoples;
	private double price;
	
    @ManyToOne
    private Hotel hotel;
    
    public Room() {}

	public Room(int nbPeoples, double price, Hotel hotel) {
		this.nbPeoples = nbPeoples;
		this.price = price;
		this.hotel = hotel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNbPeoples() {
		return nbPeoples;
	}

	public void setNbPeoples(int nbPeoples) {
		this.nbPeoples = nbPeoples;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", nbPeoples=" + nbPeoples + ", price=" + price + ", hotel=" + hotel + "]";
	}  
	
    
    

}
