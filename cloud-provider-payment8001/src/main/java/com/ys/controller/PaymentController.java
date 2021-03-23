package com.ys.controller;

import com.ys.entities.CommonResult;
import com.ys.entities.Payment;
import com.ys.service.PaymentService;
import lombok.extern.slf4j.Slf4j;;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result =  paymentService.create(payment);
        log.info("...... " + result);
        if(result>0){
            return new CommonResult(200,"success",result);
        }else{
            return new CommonResult(444,"failed", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long Id) {
        Payment payment =  paymentService.getPaymentById(Id);
        log.info("...... " + payment);
        if(payment != null){
            return new CommonResult(200,"success",payment);
        }else{
            return new CommonResult(444,"failed = "+Id, null);
        }
    }

    public List<Payment> findAll() {
        return paymentService.findAll();
    }
}
