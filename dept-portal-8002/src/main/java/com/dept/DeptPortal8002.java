package com.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:  部门管理应用启动类
 * @Author：pengrj
 * @Date : 2018/12/24 0024 21:23
 * @version:1.0
 */

@SpringBootApplication
@EnableEurekaClient
public class DeptPortal8002 {

    public static void main(String[] args) {

        SpringApplication.run(DeptPortal8002.class,args);
    }
}
