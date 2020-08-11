package com.zyx.springcloud.service;

import com.zyx.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

    public List<Payment> getPaymentList();
}
