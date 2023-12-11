package com.flighttickitbooking.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.flighttickitbooking.dao.BookingDao;
import com.flighttickitbooking.entity.Booking;
import com.flighttickitbooking.util.HibernateUtil;

public class BookingDaoImpl implements BookingDao {

	@Override
	public Booking createBooking(Booking booking) {
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(booking);
			session.getTransaction().commit();
			return booking;
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}

	@Override
	public Booking getBooking(int id) {
		try(Session session = HibernateUtil.getSession()){
			return session.get(Booking.class, id);
		}catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Booking updateBooking(Booking booking) {
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			session.update(booking);
			session.getTransaction().commit();
			return booking;
		}catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Booking deleteBooking(Booking booking) {
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			session.delete(booking);
			session.getTransaction().commit();
			return booking;
		}catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
