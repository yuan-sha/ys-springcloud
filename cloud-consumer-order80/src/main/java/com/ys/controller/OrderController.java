package com.ys.controller;


import com.ys.entities.CommonResult;
import com.ys.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/payment/post/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(REST_URL_PREFIX+"/payment/create",payment,CommonResult.class);
    }

    @PostMapping(value = "/consumer/payment/postForEntity/create")
    public CommonResult create2(Payment payment) {
        ResponseEntity<CommonResult> entity =  restTemplate.postForEntity(REST_URL_PREFIX+"/payment/create",payment,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult(444,"failed");
        }
    }


    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        // GetForObject: JSON
        return restTemplate.getForObject(REST_URL_PREFIX+"/payment/get/"+id, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/getForEntity/{id}")
    public CommonResult getPaymentById2(@PathVariable("id") Long id) {
        // RespnonseEntity, Response Header, Status Code, Response Boday
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(REST_URL_PREFIX+"/payment/get/"+id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult(444,"failed");
        }
    }
}
