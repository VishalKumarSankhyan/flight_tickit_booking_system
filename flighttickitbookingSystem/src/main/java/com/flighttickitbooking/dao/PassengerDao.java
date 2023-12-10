package com.flighttickitbooking.dao;

import com.flighttickitbooking.entity.Passenger;

public interface PassengerDao {
	Passenger createPassenger(Passenger passenger);
	Passenger getPassenger(int id);
	Passenger updatePassenger(Passenger passenger);
	Passenger deletePassenger(Passenger passenger);
}
