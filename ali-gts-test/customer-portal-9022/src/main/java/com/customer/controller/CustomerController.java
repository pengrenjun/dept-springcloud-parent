package com.customer.controller;

import com.customer.entity.StoreRoom;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Description:  调用订单管理和库存微服务接口 进行信息的处理
 * @Author：pengrj
 * @Date : 2018/12/24 0024 20:59
 * @version:1.0
 */

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;



    @RequestMapping(value = "/cusomer/order", method = RequestMethod.POST)
    public boolean order(Integer product_no,Integer product_number){
        return customerService.orderProduct(product_no,product_number);

    }


    @RequestMapping(value = "/cusomer/productList", method = RequestMethod.GET)
    public List<StoreRoom> productList(){
        return customerService.getProductList();

    }



}
