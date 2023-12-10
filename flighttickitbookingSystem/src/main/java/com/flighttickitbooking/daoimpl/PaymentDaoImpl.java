package com.flighttickitbooking.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.flighttickitbooking.dao.PaymentDao;
import com.flighttickitbooking.entity.Payment;
import com.flighttickitbooking.util.HibernateUtil;

public class PaymentDaoImpl implements PaymentDao {

	@Override
	public Payment createPayment(Payment payment) {
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(payment);
			session.getTransaction().commit();
			return payment;
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}

	@Override
	public Payment getPayment(int id) {
		try(Session session = HibernateUtil.getSession()){
			return session.get(Payment.class, id);
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}

	@Override
	public Payment updatePayment(Payment payment) {
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			session.update(payment);
			session.getTransaction().commit();
			return payment;
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}

	@Override
	public Payment deletePayment(Payment payment) {
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			session.delete(payment);
			session.getTransaction().commit();
			return payment;
		}catch(HibernateException e) {
			System.out.println(e.getCause().getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return null;
	}

}
