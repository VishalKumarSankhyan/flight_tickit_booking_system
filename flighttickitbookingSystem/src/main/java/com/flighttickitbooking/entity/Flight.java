package com.flighttickitbooking.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String departureAirport;
	private String arrivalAirport;
	@Temporal(TemporalType.DATE)
	private Date departureDate;
	@Temporal(TemporalType.DATE)
	private Date arrivalDate;
	@Temporal(TemporalType.TIME)
	private Date departureTime;
	@Temporal(TemporalType.TIME)
	private Date arrivalTime;
	private int totalSeat;
	private int allocatedSeat;
	private double baseFare;

	public Flight() {
		super();
	}

	public Flight(int id, String departureAirport, String arrivalAirport, Date departureDate, Date arrivalDate,
			Date departureTime, Date arrivalTime, int totalSeat, int allocatedSeat, double baseFare) {
		super();
		this.id = id;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.totalSeat = totalSeat;
		this.allocatedSeat = allocatedSeat;
		this.baseFare = baseFare;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public int getAllocatedSeat() {
		return allocatedSeat;
	}

	public void setAllocatedSeat(int allocatedSeat) {
		this.allocatedSeat = allocatedSeat;
	}

	public double getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}

	@Override
	public String toString() {
		return "[id = " + id + ", DepartureAirport = " + departureAirport + ", Arrival Airport = " + arrivalAirport
				+ ", Departure Date = " + departureDate + ", Arrival Date = " + arrivalDate + ", Departure Time = "
				+ departureTime + ", Arrival Time = " + arrivalTime + ", Total Seat = " + totalSeat + ", Allocated Seat = "
				+ allocatedSeat + ", Base Fare = " + baseFare + "]";
	}
}
