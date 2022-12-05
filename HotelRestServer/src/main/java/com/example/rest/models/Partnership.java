package com.example.rest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Partnership {
	@Id
	@GeneratedValue
	private long id;
	
    @ManyToOne
    private Hotel hotel;
    
    @ManyToOne
    private Agency agency;
    
    private double discount;
    
    public Partnership() {
    	
    }

	public Partnership(Hotel hotel, Agency agency, double discount) {
		this.hotel = hotel;
		this.agency = agency;
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Partnership [id=" + id + ", hotel=" + hotel + ", agency=" + agency + ", discount=" + discount + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
    
    
	
}
