package com.flighttickitbooking.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Booking booking;
	@Temporal(TemporalType.TIMESTAMP)
	private Date paymentDate;
	private double paymentAmount;
	private String PaymentMethod;
	private String PayementStatus;

	public Payment() {
		super();
	}

	public Payment(int id, Booking booking, Date paymentDate, double paymentAmount, String paymentMethod,
			String payementStatus) {
		super();
		this.id = id;
		this.booking = booking;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
		PaymentMethod = paymentMethod;
		PayementStatus = payementStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentMethod() {
		return PaymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
	}

	public String getPayementStatus() {
		return PayementStatus;
	}

	public void setPayementStatus(String payementStatus) {
		PayementStatus = payementStatus;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", booking=" + booking + ", paymentDate=" + paymentDate + ", paymentAmount="
				+ paymentAmount + ", PaymentMethod=" + PaymentMethod + ", PayementStatus=" + PayementStatus + "]";
	}
}
