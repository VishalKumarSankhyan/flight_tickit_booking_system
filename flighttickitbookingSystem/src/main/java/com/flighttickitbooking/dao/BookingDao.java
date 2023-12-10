package com.flighttickitbooking.dao;

import com.flighttickitbooking.entity.Booking;

public interface BookingDao {
	Booking createBooking(Booking booking);
	Booking getBooking(int id);
	Booking updateBooking(Booking booking);
	Booking deleteBooking(Booking booking);
}
