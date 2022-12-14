package com.example.rest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Client {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String surname;
	private String card;
	private String exp;
	private String cvv;

    
    public Client() {
    }

	public Client( String name, String surname, String card, String exp,String cvv) {
		this.name = name;
		this.surname = surname;
		this.card = card;
		this.exp = exp;
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", surname=" + surname + ", card=" + card + ", cvv=" + cvv
				+ "]";
	}
	
	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}    
    
}
