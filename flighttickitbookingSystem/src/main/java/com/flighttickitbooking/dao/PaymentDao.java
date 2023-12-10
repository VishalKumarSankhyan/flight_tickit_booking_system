package com.flighttickitbooking.dao;

import com.flighttickitbooking.entity.Payment;

public interface PaymentDao {
	Payment createPayment(Payment payment);
	Payment getPayment(int id);
	Payment updatePayment(Payment payment);
	Payment deletePayment(Payment payment);
}
