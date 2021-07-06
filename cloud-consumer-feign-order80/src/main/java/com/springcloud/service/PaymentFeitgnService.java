package com.springcloud.service;

import com.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient( value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeitgnService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long Id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}