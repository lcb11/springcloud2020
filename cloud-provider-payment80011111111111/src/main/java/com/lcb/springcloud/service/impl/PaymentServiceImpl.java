package com.lcb.springcloud.service.impl;

import com.lcb.springcloud.dao.PaymentDao;
import com.lcb.springcloud.entities.Payment;
import com.lcb.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){

        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){

        return paymentDao.getPaymentById(id);
    }
}
