package com.orderform.controller;

import com.orderform.entity.OrderForm;
import com.orderform.service.OrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:  订单服务对外接口
 * @Author：pengrj
 * @Date : 2018/12/19 0019 23:34
 * @version:1.0
 */

@RestController
public class OrderFormController {

    @Autowired
    private OrderFormService orderFormService;


    @RequestMapping(value = "/orderform/order", method = RequestMethod.POST)
    public boolean order(@RequestParam Integer product_no, @RequestParam Integer product_number)
    {
        OrderForm orderForm=new OrderForm();
        orderForm.setProduct_no(product_no);
        orderForm.setNumber(product_number);
        return orderFormService.order(orderForm);
    }


    @RequestMapping(value = "/orderform/list", method = RequestMethod.GET)
    public List<OrderForm> list()
    {
        return orderFormService.list();
    }


}
