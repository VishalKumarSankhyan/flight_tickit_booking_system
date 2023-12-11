package com.flighttickitbooking.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date bookingDate;
	@OneToOne(fetch = FetchType.EAGER)
	private Flight flight;
	@OneToOne(fetch = FetchType.EAGER)
	private Passenger passenger;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Payment payment;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Seat> seats;
	
	public Booking() {
		super();
	}

	public Booking(int id, Date bookingDate, Flight flight, Passenger passenger, Payment payment, List<Seat> seats) {
		super();
		this.id = id;
		this.bookingDate = bookingDate;
		this.flight = flight;
		this.passenger = passenger;
		this.payment = payment;
		this.seats = seats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingDate=" + bookingDate + ", flight=" + flight + ", passenger=" + passenger
				+ ", seats=" + seats + "]";
	}
	
}
