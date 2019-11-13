package com.orderform.service;

import com.orderform.entity.OrderForm;
import com.orderform.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 部门服务接口实现类
 * @Author：pengrj
 * @Date : 2018/12/19 0019 23:36
 * @version:1.0
 */

@Service
public class OrderFormServiceImpl implements OrderFormService {

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public boolean order(OrderForm orderForm) {
        boolean order = orderMapper.order(orderForm);
        return order;
    }

    @Override
    public List<OrderForm> list() {
        return orderMapper.list();
    }
}
