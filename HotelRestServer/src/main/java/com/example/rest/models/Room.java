package com.example.rest.models;

public class Room {

	private int id;
	private int nbBeds;
	private double price;

	public Room(int id, int nbBeds, double price) {
		this.id = id;
		this.nbBeds = nbBeds;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbBeds() {
		return nbBeds;
	}

	public void setNbBeds(int nbBeds) {
		this.nbBeds = nbBeds;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Room [Numero=" + id + ", Nombre de lit=" + nbBeds + ", price=" + price + "]";
	}
	
	
	
	

}
