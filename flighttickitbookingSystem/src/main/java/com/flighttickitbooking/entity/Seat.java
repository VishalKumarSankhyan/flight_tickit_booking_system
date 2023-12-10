package com.flighttickitbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Override
	public String toString() {
		return "Seat [id=" + id + "]";
	}
	
}
