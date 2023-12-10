package com.flighttickitbooking.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.flighttickitbooking.dao.SeatDao;
import com.flighttickitbooking.entity.Seat;
import com.flighttickitbooking.util.HibernateUtil;

public class SeatDaoImpl implements SeatDao {

	@Override
	public Seat createSeat(Seat seat) {
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(seat);
			session.getTransaction().commit();
			return seat;
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}

	@Override
	public Seat getSeat(int id) {
		try(Session session = HibernateUtil.getSession()){
			return session.get(Seat.class, id);
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}

	@Override
	public Seat updateSeat(Seat seat) {
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			session.update(seat);
			session.getTransaction().commit();
			return seat;
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}

	@Override
	public Seat deleteSeat(Seat seat) {
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			session.delete(seat);
			session.getTransaction().commit();
			return seat;
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}

}
