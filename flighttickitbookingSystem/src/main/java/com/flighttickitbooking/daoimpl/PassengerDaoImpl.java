package com.flighttickitbooking.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.flighttickitbooking.dao.PassengerDao;
import com.flighttickitbooking.entity.Passenger;
import com.flighttickitbooking.util.HibernateUtil;

public class PassengerDaoImpl implements PassengerDao {
	@Override
	public Passenger createPassenger(Passenger passenger) {
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(passenger);
			session.getTransaction().commit();
			return passenger;
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}
	
	@Override
	public Passenger getPassenger(int id) {
		try(Session session = HibernateUtil.getSession()){
			return session.get(Passenger.class, id);
		}catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Passenger updatePassenger(Passenger passenger) {
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			session.update(passenger);
			session.getTransaction().commit();
			return passenger;
		}catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Passenger deletePassenger(Passenger passenger) {
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			session.delete(passenger);
			session.getTransaction().commit();
			return passenger;
		}catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	};
}
