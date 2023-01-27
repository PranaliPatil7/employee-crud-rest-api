package com.prowings.empcrud.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class Address {
	
	@Column
	int pin;
	@Column
	String city;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	
}
