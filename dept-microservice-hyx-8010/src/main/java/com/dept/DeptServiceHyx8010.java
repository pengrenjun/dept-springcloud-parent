package com.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: 部门服务中心启动类
 * @Author：pengrj
 * @Date : 2018/12/19 0019 23:46
 * @version:1.0
 */
@SpringBootApplication
@EnableEurekaClient //eureka client
@EnableCircuitBreaker//服务熔断处理
@EnableDiscoveryClient //eureka 服务发现
public class DeptServiceHyx8010 {
    public static void main(String[] args) {
        SpringApplication.run(DeptServiceHyx8010.class,args);
    }
}
