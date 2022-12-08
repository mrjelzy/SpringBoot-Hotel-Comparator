package com.example.rest.models;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne
	private Client client;
	@OneToOne
	private Agency agency;
	@OneToOne
	private Room room;
	
	private LocalDate start;
	private LocalDate end;
	
	public Booking() {}
	
	public Booking(Client client,Agency agency, Room room, LocalDate start, LocalDate end) {
		this.agency = agency;
		this.client = client;
		this.room = room;
		this.start = start;
		this.end = end;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
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

	@Override
	public String toString() {
		return "Booking [id=" + id + ", agency=" + agency  + ", room=" + room 
				+ ", start=" + start + ", end=" + end + "]";
	}
	

	
}
