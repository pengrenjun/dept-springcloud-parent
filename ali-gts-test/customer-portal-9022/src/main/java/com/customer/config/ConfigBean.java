package com.customer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author：pengrj
 * @Date : 2018/12/24 0024 20:53
 * @version:1.0
 */
@Configuration
public class ConfigBean {

    //调用微服务接口模板类 @LoadBalanced结合Ribbon和Eureka 实现8001和8005服务的负载均衡
    //Ribbon默认采用轮询的方式调用8001和8005服务
    //Ribbon 会根据微服务的实例名称去eureka查询接口 不需要指定ip和 port
    @Bean
    @LoadBalanced ////实现负载均衡注解
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }


    //Ribbon默认采用轮询的方式调用注册进入Eureka的服务,实现简单的负载均衡的效果
    //可以 进行配置 才会RibbonRule实例即可切换 服务的访问算法 也可以返回自定义的负载均衡算法
    //这部分的访问算法类通过主启动类@RibbonClient指定
       @Bean
        public IRule ribbonIrule(){
            return  new RoundRobinRule();
        }

}
