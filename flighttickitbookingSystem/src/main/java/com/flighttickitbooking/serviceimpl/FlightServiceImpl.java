package com.flighttickitbooking.serviceimpl;

import java.util.List;

import com.flighttickitbooking.dao.FlightDao;
import com.flighttickitbooking.daoimpl.FlightDaoImpl;
import com.flighttickitbooking.entity.Flight;
import com.flighttickitbooking.service.FlightService;

public class FlightServiceImpl implements FlightService {

	FlightDao flightDao = new FlightDaoImpl();

	@Override
	public Flight createFlight(Flight flight) {
		return flightDao.createFlight(flight);
	}

	@Override
	public Flight getFlight(int id) {
		return flightDao.getFlight(id);
	}

	@Override
	public Flight updateFlight(Flight flight) {
		return flightDao.updateFlight(flight);
	}

	@Override
	public Flight deleteFlight(Flight flight) {
		return flightDao.deleteFlight(flight);
	}

	@Override
	public List<Flight> getFlightsByDepartureAirport(String departureAirport) {
		return flightDao.getFlightsByDepartureAirport(departureAirport);
	}

	@Override
	public List<Flight> getFlightsByArrivalAirport(String arrivalAirport) {
		return flightDao.getFlightsByArrivalAirport(arrivalAirport);
	}

	@Override
	public List<Flight> getFlightsByDepartureAndArrivalAirport(String departureAirport, String arrivalAirport) {
		return flightDao.getFlightsByDepartureAndArrivalAirport(departureAirport, arrivalAirport);
	}

}
