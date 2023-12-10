package com.flighttickitbooking.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.flighttickitbooking.dao.FlightDao;
import com.flighttickitbooking.entity.Flight;
import com.flighttickitbooking.util.HibernateUtil;

public class FlightDaoImpl implements FlightDao {

	@Override
	public Flight createFlight(Flight flight) {
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(flight);
			session.getTransaction().commit();
			return flight;
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}

	@Override
	public Flight getFlight(int id) {
		try(Session session = HibernateUtil.getSession()){
			return session.get(Flight.class, id);
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}

	@Override
	public Flight updateFlight(Flight flight) {
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			session.update(flight);
			session.getTransaction().commit();
			return flight;
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}

	@Override
	public Flight deleteFlight(Flight flight) {
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			session.delete(flight);
			session.getTransaction().commit();
			return flight;
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}

	@Override
	public List<Flight> getFlightsByDepartureAirport(String departureAirport) {
		try(Session session = HibernateUtil.getSession()){
			Query<Flight> query = session.createQuery("from Flight where departureAirport =:departureAirport");
			query.setParameter("departureAirport", departureAirport);
			return query.list();
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}

	@Override
	public List<Flight> getFlightsByArrivalAirport(String arrivalAirport) {
		try(Session session = HibernateUtil.getSession()){
			Query<Flight> query = session.createQuery("from Flight where arrivalAirport =:arrivalAirport");
			query.setParameter("arrivalAirport", arrivalAirport);
			return query.list();
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}

	@Override
	public List<Flight> getFlightsByDepartureAndArrivalAirport(String departureAirport, String arrivalAirport) {
		try(Session session = HibernateUtil.getSession()){
			Query<Flight> query = session.createQuery("from Flight where departureAirport =:departureAirport and arrivalAirport =:arrivalAirport");
			query.setParameter("departureAirport", departureAirport);
			query.setParameter("arrivalAirport", arrivalAirport);
			return query.list();
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}

}
