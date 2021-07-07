package com.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return "thread pool: "+ Thread.currentThread().getName()+" paymentInfo_OK,id: "+id+"\t"+"o(n_n)o`~";
    }

    public String paymentInfo_timeout(Integer id){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "thread pool: "+ Thread.currentThread().getName()+" paymentInfo_timeout,id: "+id+"\t"+"o(n_n)o`~";
    }

}
