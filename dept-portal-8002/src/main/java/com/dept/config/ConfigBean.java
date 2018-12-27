package com.dept.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:  部门应用的配置类 等同于spring里面的applicationcontext.xml
 * @Author：pengrj
 * @Date : 2018/12/24 0024 20:53
 * @version:1.0
 */
@Configuration
public class ConfigBean {

    //调用微服务接口模板类 @LoadBalanced结合Ribbon和Eureka 实现8001和8005服务的负载均衡
    //Ribbon默认采用轮询的方式调用8001和8005服务
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){

        return  new RestTemplate();
    }
}
