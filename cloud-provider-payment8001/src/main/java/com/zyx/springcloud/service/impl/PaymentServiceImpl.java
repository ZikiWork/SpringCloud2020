package com.zyx.springcloud.service.impl;

import com.zyx.springcloud.dao.PaymentDao;
import com.zyx.springcloud.entities.Payment;
import com.zyx.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource//推荐使用Resouce
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public List<Payment> getPaymentList() {
        return paymentDao.getPaymentList();
    }
    
    final AtomicReference<ExecutorService> executorService = new AtomicReference<>(Executors.newFixedThreadPool(5));


}
