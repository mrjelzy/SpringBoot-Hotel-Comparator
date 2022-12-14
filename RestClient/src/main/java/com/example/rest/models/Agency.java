package com.example.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Agency {

	/* ATTRIBUTES */
	private long id;
	private String name;
	private String login;
	private String password;
	private double discount;

	public Agency() {
	}

	public Agency(String name, String login, String password, double discount) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.discount = discount;
		// this.clients = new ArrayList<Client>();

	}

	/* METHODS */

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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Agency [id=" + id + ", name=" + name + ", login=" + login + ", password=" + password + ", discount="
				+ discount + "]";
	}

	

}
