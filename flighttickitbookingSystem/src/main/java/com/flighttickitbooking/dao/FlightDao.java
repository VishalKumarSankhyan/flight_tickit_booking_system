package com.flighttickitbooking.dao;

import java.util.List;

import com.flighttickitbooking.entity.Flight;

public interface FlightDao {
	Flight createFlight(Flight flight);
	Flight getFlight(int id);
	
	List<Flight> getFlightsByDepartureAirport(String departureAirport);
	List<Flight> getFlightsByArrivalAirport(String arrivalAirport);
	List<Flight> getFlightsByDepartureAndArrivalAirport(String departureAirport, String arrivalAirport);
	
	Flight updateFlight(Flight flight);
	Flight deleteFlight(Flight flight);
}
