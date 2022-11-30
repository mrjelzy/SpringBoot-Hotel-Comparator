package com.example.rest.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Hotel {

	/* ATTRIBUTES */
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String adress;
	private String city;
	private String country;
	private int nbStars;
	private ArrayList<Room> rooms;
	private ArrayList<Reservation> reservations;

	public Hotel() {

	}

	public Hotel(String name, String adress, String city, String country, int nbStars) {
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.city = city;
		this.country = country;
		this.nbStars = nbStars;
		rooms = new ArrayList<Room>();
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

	public void addRoom(int id, int nbBeds, double price) {
		Room r = new Room(id, nbBeds, price);
		this.rooms.add(r);
	}

	public void removeRoom(Room r) {
		rooms.remove(r);
	}

	public ArrayList<Reservation> getReservartion() {
		return this.reservations;
	}
	
	public int addReservation(int idR, Client client, LocalDate startDate, LocalDate endDate) {
		Reservation r = new Reservation(idR,this,this.rooms.get(idR), client, startDate, endDate);
		boolean state = reservations.add(r);
		return state == false ? -1 : idR;
	}
	
	public void removeReservation(Reservation r) {
		reservations.remove(r);
	}

	public ArrayList<Room> freeRooms(LocalDate start, LocalDate end, int nbPeoples) {
		ArrayList<Room> free = new ArrayList<Room>();
		for (Room r : this.rooms) {
			if (r.getNbBeds() == nbPeoples) {
				int i = 0;
				boolean conflict = false;
				while (reservations.size() > i && conflict == false) {
					Reservation book = reservations.get(i);
					if (book.getRoom().equals(r)) {
						if (start.isBefore(book.getEndDate()) && end.isAfter(book.getStartDate())) {
							conflict = true;
						}
					}
					i++;
				}
				if (!conflict) {
					free.add(r);
				}
			}
		}
		return free;
	}

}
