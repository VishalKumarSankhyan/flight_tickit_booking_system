package com.flighttickitbooking.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(length = 50)
	private String houseNumber;
	@Column(length = 50)
	private String city;
	@Column(length = 50)
	private String state;
	@Column(length = 50)
	private String country;
	@Column(length = 50)
	private int pincode;

	public Address() {
		super();
	}

	public Address(String houseNumber, String city, String state, String country, int pincode) {
		super();
		this.houseNumber = houseNumber;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "[houseNumber = " + houseNumber + ", city = " + city + ", state = " + state + ", country = " + country
				+ ", pincode = " + pincode + "]";
	}
}
