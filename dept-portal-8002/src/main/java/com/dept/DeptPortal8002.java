package com.dept;

import com.RibbonRule.SRRoundRobinRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description:  部门管理应用启动类
 * @Author：pengrj
 * @Date : 2018/12/24 0024 21:23
 * @version:1.0
 */

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="dept-com.dept.service",configuration =SRRoundRobinRule.class)
public class DeptPortal8002 {

    public static void main(String[] args) {

        SpringApplication.run(DeptPortal8002.class,args);
    }
}
