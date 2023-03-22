package com.lcb.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 *
 */
@Service
public class PaymentService {


    //正常访问
    public String paymentInfo_Ok(Integer id){
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_ok,id:"+id+"\t"+"hello,hystrix!!!";
    }


    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id){

        int timeNumber=5;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_TimeOut,id:"+id+"\t"+"hello,hystrix!!!"+"耗时:"+timeNumber+"秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池"+Thread.currentThread().getName()+"return \"线程池\"+Thread.currentThread().getName()+\"paymentInfo_TimeOut,id:\"+id+\"\\t\"+\"hello,hystrix!!!\"+\"耗时:\"+timeNumber+\"秒\";,id:"+id+"\t"+"hello,hystrix!!!";
    }
}
