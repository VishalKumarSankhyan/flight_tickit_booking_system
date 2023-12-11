package com.flighttickitbooking.service;

import com.flighttickitbooking.entity.Seat;

public interface SeatService {
	Seat createSeat(Seat Seat);
	Seat getSeat(int id);
	Seat updateSeat(Seat Seat);
	Seat deleteSeat(Seat Seat);
}
