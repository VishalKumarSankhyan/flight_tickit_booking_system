package com.flighttickitbooking.service;

import com.flighttickitbooking.entity.Payment;

public interface PaymentService {
	Payment createPayment(Payment payment);
	Payment getPayment(int id);
	Payment updatePayment(Payment payment);
	Payment deletePayment(Payment payment);
}
