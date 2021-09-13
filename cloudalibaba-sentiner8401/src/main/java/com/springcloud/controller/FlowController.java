package com.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/testhotkey")
    @SentinelResource(value = "testhotkey", blockHandler = "deal_testhotkey")
    public String testhotkey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "testhotkey";
    }

    public String deal_testhotkey(String p1, String p2, BlockException blockException){
        return "deal_testhotkey";
    }
}
