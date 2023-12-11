package com.flighttickitbooking.serviceimpl;

import com.flighttickitbooking.dao.PaymentDao;
import com.flighttickitbooking.daoimpl.PaymentDaoImpl;
import com.flighttickitbooking.entity.Payment;
import com.flighttickitbooking.service.PaymentService;

public class PaymentServiceImpl implements PaymentService {
	PaymentDao paymentDao = new PaymentDaoImpl();
	@Override
	public Payment createPayment(Payment payment) {
		return paymentDao.createPayment(payment);
	}

	@Override
	public Payment getPayment(int id) {
		return paymentDao.getPayment(id);
	}

	@Override
	public Payment updatePayment(Payment payment) {
		return paymentDao.updatePayment(payment);
	}

	@Override
	public Payment deletePayment(Payment payment) {
		return paymentDao.deletePayment(payment);
	}

}
