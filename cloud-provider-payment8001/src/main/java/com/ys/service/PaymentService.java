package com.ys.service;

import com.ys.entities.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("Id") Long Id);

    public List<Payment> findAll();
}
