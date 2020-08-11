package com.zyx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Author: Administrator
 * Date:  2020/6/28 22:54
 */
@RestController
@Slf4j
public class OrderConsulController {

    private static final String PAYMENT_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    private String paymentInfo() {

        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }

    @GetMapping("/actuator/health")
    public String retStr() {
        return "success";
    }

}
