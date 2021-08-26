package com.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowController {

    @GetMapping("/getA")
    public String getA(){
        return "AAAAA";
    }

    @GetMapping("/getB")
    public String getB(){
        return "BBBBB";
    }
}
