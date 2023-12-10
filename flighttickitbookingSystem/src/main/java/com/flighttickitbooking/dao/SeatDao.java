package com.flighttickitbooking.dao;

import com.flighttickitbooking.entity.Seat;

public interface SeatDao {
	Seat createSeat(Seat seat);
	Seat getSeat(int id);
	Seat updateSeat(Seat seat);
	Seat deleteSeat(Seat seat);
}
