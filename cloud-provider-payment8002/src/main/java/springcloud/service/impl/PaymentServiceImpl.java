package com.springcloud.service.impl;

import com.springcloud.dao.PaymentDao;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
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
