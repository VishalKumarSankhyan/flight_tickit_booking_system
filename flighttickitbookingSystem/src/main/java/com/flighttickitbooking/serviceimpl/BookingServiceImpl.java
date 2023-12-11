package com.flighttickitbooking.serviceimpl;

import com.flighttickitbooking.dao.BookingDao;
import com.flighttickitbooking.daoimpl.BookingDaoImpl;
import com.flighttickitbooking.entity.Booking;
import com.flighttickitbooking.service.BookingService;

public class BookingServiceImpl implements BookingService {
	BookingDao bookingDao = new BookingDaoImpl();

	@Override
	public Booking createBooking(Booking booking) {
		return bookingDao.createBooking(booking);
	}

	@Override
	public Booking getBooking(int id) {
		return bookingDao.getBooking(id);
	}

	@Override
	public Booking updateBooking(Booking booking) {
		return bookingDao.updateBooking(booking);
	}

	@Override
	public Booking deleteBooking(Booking booking) {
		return bookingDao.deleteBooking(booking);
	}
	
}
