package com.zyx.springcloud.controller;

import com.zyx.springcloud.entities.CommonResult;
import com.zyx.springcloud.entities.Payment;
import com.zyx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j//开启注解打印日志
public class PaymentController {
    private final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private PaymentService paymentService;


    /**
     * 注解@RequestBody接收的参数是来自requestBody中，即请求体。
     * 一般用于处理非 Content-Type: application/x-www-form-urlencoded编码格式的数据，
     * 比如：application/json、application/xml等类型的数据。
     * 就application/json类型的数据而言，使用注解@RequestBody可以将body里面所有的json数据传到后端，
     * 后端再进行解析。
     *
     * @param payment
     * @return
     */
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {//加上@RequestBody注解
        int result = paymentService.create(payment);
        log.info("插入数据：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功！ServerSport  :" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败！", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功，ServerSport  :" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID：" + id, null);
        }
    }

    @GetMapping("/payment/getList")
    public CommonResult<List<Payment>> getAllPayment() {
        logger.info("getAllPayment to " + serverPort);
        List<Payment> payment = paymentService.getPaymentList();
        return new CommonResult(200, "查询成功ServerSport  :" + serverPort, payment);
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        //得到服务列表
        List<String> discoveryList = discoveryClient.getServices();
        for (String element : discoveryList
        ) {
            logger.info("********element:  " + element);
        }

        //得到某个服务下的实例列表
        List<ServiceInstance> instanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instanceList) {
            logger.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }
}
