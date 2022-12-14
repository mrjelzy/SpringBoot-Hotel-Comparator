package com.example.rest.models;


public class Room {
	
	private long id;
	private int nbPeoples;
	private double price;
	private String urlImg;

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public Room() {
	}

	public Room(long id,int nbPeoples, double price, String urlImg) {
		this.id=id;
		this.nbPeoples = nbPeoples;
		this.price = price;
		this.urlImg = urlImg;
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