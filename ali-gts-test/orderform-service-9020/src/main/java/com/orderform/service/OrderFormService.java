package com.orderform.service;

import com.orderform.entity.OrderForm;

import java.util.List;

public interface OrderFormService {

    /**
     * 订购商品
     */
     boolean order(OrderForm orderForm);

     List<OrderForm> list();
}
