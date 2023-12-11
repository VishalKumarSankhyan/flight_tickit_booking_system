package com.flighttickitbooking.serviceimpl;

import com.flighttickitbooking.dao.SeatDao;
import com.flighttickitbooking.daoimpl.SeatDaoImpl;
import com.flighttickitbooking.entity.Seat;
import com.flighttickitbooking.service.SeatService;

public class SeatServiceImpl implements SeatService {
	SeatDao seatDao = new SeatDaoImpl();
	@Override
	public Seat createSeat(Seat Seat) {
		return seatDao.createSeat(Seat);
	}

	@Override
	public Seat getSeat(int id) {
		return seatDao.getSeat(id);
	}

	@Override
	public Seat updateSeat(Seat Seat) {
		return seatDao.updateSeat(Seat);
	}

	@Override
	public Seat deleteSeat(Seat Seat) {
		return seatDao.deleteSeat(Seat);
	}
	
}
