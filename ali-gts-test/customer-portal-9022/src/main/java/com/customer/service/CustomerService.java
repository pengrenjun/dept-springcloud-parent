package com.customer.service;

import com.customer.entity.StoreRoom;

import java.util.List;

/**
 * @Description TODO
 * @Date 2019/5/6 0006 下午 2:21
 * @Created by Pengrenjun
 */

public interface CustomerService {


     boolean orderProduct(Integer product_no, Integer product_number) ;

     List<StoreRoom> getProductList();
}
