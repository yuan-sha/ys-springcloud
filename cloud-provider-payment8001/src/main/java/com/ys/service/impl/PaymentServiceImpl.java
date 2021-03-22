package com.ys.service.impl;

import com.ys.dao.PaymentDao;
import com.ys.entities.Payment;
import com.ys.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long Id) {
        return paymentDao.getPaymentById(Id);
    }

    @Override
    public List<Payment> findAll() {
        return paymentDao.findAll();
    }
}
