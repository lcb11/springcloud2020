package com.lcb.springcloud.controller;

import com.lcb.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 */
@RestController
@Slf4j
public class OrderHystrixController {


    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id")Integer id){

        String result=paymentHystrixService.paymentInfo_ok(id);
        return result;
    }


    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id")Integer id){
        String result=paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
}
}
