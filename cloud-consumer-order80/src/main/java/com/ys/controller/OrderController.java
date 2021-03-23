package com.ys.controller;


import com.ys.entities.CommonResult;
import com.ys.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "/comsumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(REST_URL_PREFIX+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/comsumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX+"/payment/get/"+id, CommonResult.class);
    }

}
