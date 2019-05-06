package com.hyxdashbord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description:  服务监控主启动类
 * @Author：pengrj
 * @Date : 2018/12/31 0031 12:20
 * @version:1.0
 */

@SpringBootApplication
@EnableHystrixDashboard
public class MirHyxDashbord9001 {

    public static void main(String[] args) {
        SpringApplication.run(MirHyxDashbord9001.class,args);
    }
}
