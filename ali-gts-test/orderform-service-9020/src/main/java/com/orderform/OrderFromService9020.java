package com.orderform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: 订单服务中心启动类
 * @Author：pengrj
 * @Date : 2018/12/19 0019 23:46
 * @version:1.0
 */
@SpringBootApplication
@EnableEurekaClient //eureka client
@EnableDiscoveryClient //eureka 服务发现
public class OrderFromService9020 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFromService9020.class,args);
    }
}
