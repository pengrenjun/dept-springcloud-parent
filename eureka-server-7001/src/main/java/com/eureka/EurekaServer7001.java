package com.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description:  Eureka集群 7001服务
 * @Author：pengrj
 * @Date : 2018/12/24 0024 22:25
 * @version:1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001 {

    public static void main(String[] args) {

        SpringApplication.run(EurekaServer7001.class,args);
    }
}
