package com.example.rest.models;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Agency {

	/* ATTRIBUTES */
	
	private long id;
	private String name;
	private String login;
	private String password;
	private double discount;
	ArrayList<Client> clients;

	public Agency() {
	}

	public Agency(String name, String login, String password, double discount) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.discount = discount;
		this.clients = new ArrayList<Client>();

	}

	/* METHODS */
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
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
	
	
	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	/*@Override
	public int hashCode() {
		return Objects.hash(/*clients, discount, id, login, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agency other = (Agency) obj;
		return Objects.equals(clients, other.clients)
				&& Double.doubleToLongBits(discount) == Double.doubleToLongBits(other.discount) && id == other.id
				&& Objects.equals(login, other.login) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "Agency [id=" + id + ", name=" + name + ", login=" + login + ", password=" + password + ", discount="
				+ discount + ", clients=" + clients + "]";
	}

	public boolean addClient(Client a) {
		return clients.add(a);
	}

	public boolean removeClient(Client a) {
		return clients.remove(a);
	}*/

}
