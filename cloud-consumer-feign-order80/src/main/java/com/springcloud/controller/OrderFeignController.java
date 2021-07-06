package com.springcloud.controller;


import com.springcloud.entities.CommonResult;
import com.springcloud.service.PaymentFeitgnService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeitgnService paymentFeitgnService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long Id) {
        return paymentFeitgnService.getPaymentById(Id);
    }
}
