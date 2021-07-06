package com.springcloud.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

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
            return new CommonResult(200,"success, serverPort="+serverPort,payment);
        }else{
            return new CommonResult(444,"failed = "+Id, null);
        }
    }

    public List<Payment> findAll() {
        return paymentService.findAll();
    }

    @RequestMapping(value = "/payment/discovery", method= RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("*********"+list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance element:srvList) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
