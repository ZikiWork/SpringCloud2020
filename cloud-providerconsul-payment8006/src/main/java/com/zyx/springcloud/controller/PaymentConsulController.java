package com.zyx.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Administrator
 * Date:  2020/6/28 22:35
 */
@RestController
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentConsul() {
        return "springCloud with consul : " + serverPort + " \t" + IdUtil.simpleUUID().toString();
    }

    @GetMapping("/actuator/health")
    public String retStr() {
        return "success";
    }
}
