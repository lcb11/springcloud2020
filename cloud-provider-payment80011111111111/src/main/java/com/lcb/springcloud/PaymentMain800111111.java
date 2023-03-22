package com.lcb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
  * @Author lcb
  * @Description
  * @Date 2022/3/12
  * @Param
  * @return
  **/

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain800111111 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain800111111.class,args);
    }
}
