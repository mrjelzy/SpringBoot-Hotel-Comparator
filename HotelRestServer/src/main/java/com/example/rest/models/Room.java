package com.example.rest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Room {
	@Id
	@GeneratedValue
	private long id;
	private int nbPeoples;
	private double price;
	
    public Room() {}

	public Room(int nbPeoples, double price) {
		this.nbPeoples = nbPeoples;
		this.price = price;
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

	@Override
	public String toString() {
		return "Room [id=" + id + ", nbPeoples=" + nbPeoples + ", price=" + price + "]";
	}  
	
    
    

}
