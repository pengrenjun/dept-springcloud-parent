package com.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description: 微服务路由网关主启动类
 * @Author：pengrj
 * @Date : 2018/12/31 0031 14:31
 * @version:1.0
 */
@SpringBootApplication
@EnableZuulProxy
public class MirZuul9002 {

    public static void main(String[] args) {
        SpringApplication.run(MirZuul9002.class,args);
    }
}
