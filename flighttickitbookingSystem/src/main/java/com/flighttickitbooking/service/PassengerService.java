package com.flighttickitbooking.service;

import com.flighttickitbooking.entity.Passenger;

public interface PassengerService {
	Passenger createPassenger(Passenger passenger);
	Passenger getPassenger(int id);
	Passenger updatePassenger(Passenger passenger);
	Passenger deletePassenger(Passenger passenger);
}
