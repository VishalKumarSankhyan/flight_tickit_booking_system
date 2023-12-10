package com.flighttickitbooking.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Embedded
	private Name name;
	@Column(nullable = false,length = 50, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String phoneNumber;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	private String gender;
	@Embedded
	private Address address;

	public Passenger()	 {
		super();
	}

	public Passenger(int id, Name name, String email, String phoneNumber, Date dateOfBirth, String gender,
			Address address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Passenger [id = " + id + ", name = " + name + ", email = " + email + ", phoneNumber = " + phoneNumber
				+ ", dateOfBirth = " + dateOfBirth + ", gender = " + gender + ", address = " + address + "]";
	}
}
