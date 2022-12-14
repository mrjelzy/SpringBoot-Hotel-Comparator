package com.example.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Agency {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@JsonIgnore
	private String login;
	@JsonIgnore
	private String password;
	private double discount;
	
	public Agency() {
	}
	
	public Agency(String name, String login, String password, double discount) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.discount = discount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Agency [id=" + id + ", name=" + name + ", login=" + login + ", password=" + password + "]";
	}
	
}
