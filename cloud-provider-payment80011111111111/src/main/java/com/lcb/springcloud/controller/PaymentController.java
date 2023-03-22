package com.lcb.springcloud.controller;

import com.lcb.springcloud.entities.CommonResult;
import com.lcb.springcloud.entities.Payment;
import com.lcb.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result=paymentService.create(payment);
        log.info("*****插入结果："+result);

        if (result>0){
            return new CommonResult(200,"插入数据库成功",result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment>  getPaymentById(@PathVariable("id") Long id){
        Payment payment=paymentService.getPaymentById(id);
        log.info("*****插入结果："+payment);

        if (payment!=null){
            return new CommonResult(200,"支付成功serverPort:  ",payment);
        }else {
            return new CommonResult(444,"没有对应的数据，查询ID:"+id,null);
        }
    }
}
