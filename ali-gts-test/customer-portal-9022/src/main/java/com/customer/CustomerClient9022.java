package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:  部门管理应用启动类
 * @Author：pengrj
 * @Date : 2018/12/24 0024 21:23
 * @version:1.0
 */


@SpringBootApplication(exclude=
        {DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableEurekaClient
public class CustomerClient9022 {

    public static void main(String[] args) {

        SpringApplication.run(CustomerClient9022.class,args);
    }
}
