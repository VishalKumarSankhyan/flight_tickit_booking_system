package com.flighttickitbooking.serviceimpl;

import com.flighttickitbooking.dao.PassengerDao;
import com.flighttickitbooking.daoimpl.PassengerDaoImpl;
import com.flighttickitbooking.entity.Passenger;
import com.flighttickitbooking.service.PassengerService;

public class PassengerServiceImpl implements PassengerService {
	
	PassengerDao passengerDao = new PassengerDaoImpl();
	
	@Override
	public Passenger createPassenger(Passenger passenger) {
		return passengerDao.createPassenger(passenger);
	}

	@Override
	public Passenger getPassenger(int id) {
		return passengerDao.getPassenger(id);
	}

	@Override
	@Deprecated
	public Passenger updatePassenger(Passenger passenger) {
		return passengerDao.updatePassenger(passenger);
	}

	@Override
	public Passenger deletePassenger(Passenger passenger) {
		return passengerDao.deletePassenger(passenger);
	}
	
}
