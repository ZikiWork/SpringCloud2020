package com.zyx.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Author: Administrator
 * Date:  2020/6/28 22:54
 */
@Configuration
/**
 * 负载均衡算法：轮询，最小连接数，权重值，随机。
 */
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced   //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
