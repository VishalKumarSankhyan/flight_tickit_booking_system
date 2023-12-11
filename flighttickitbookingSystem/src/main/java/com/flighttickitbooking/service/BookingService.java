package com.flighttickitbooking.service;

import com.flighttickitbooking.entity.Booking;

public interface BookingService {
	Booking createBooking(Booking booking);
	Booking getBooking(int id);
	Booking updateBooking(Booking booking);
	Booking deleteBooking(Booking booking);
}
