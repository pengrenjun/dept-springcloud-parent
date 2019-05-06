package com.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description:  部门管理应用启动类
 * @Author：pengrj
 * @Date : 2018/12/24 0024 21:23
 * @version:1.0
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages ={"com.dept.feigncontroller"})
@ComponentScan("com.dept")
//@RibbonClient(name="dept-com.dept.service",configuration =SRRoundRobinRule.class)
public class DeptPortal8009 {

    public static void main(String[] args) {

        SpringApplication.run(DeptPortal8009.class,args);
    }
}
