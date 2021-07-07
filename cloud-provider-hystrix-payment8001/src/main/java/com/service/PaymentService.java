package com.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return "thread pool: "+ Thread.currentThread().getName()+" paymentInfo_OK,id: "+id+"\t"+"o(n_n)o`~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3000")
    })
    public String paymentInfo_timeout(Integer id){
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "thread pool: "+ Thread.currentThread().getName()+" paymentInfo_timeout,id: "+id+"\t"+"o(n_n)o`~";
    }

    public String paymentInfo_timeoutHandler(Integer id){
        return "thread pool: "+ Thread.currentThread().getName()+" paymentInfo_timeoutHandler,id: "+id+"\t"+"o(YS)o`~";
    }

}
