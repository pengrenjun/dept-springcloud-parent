package com.customer.entity;

/**
 * @Description 订单信息
 * @Date 2019/5/6 0006 上午 10:45
 * @Created by Pengrenjun
 */
public class OrderForm {

    private Integer order_no ;
    private String order_name;
    private Integer product_no;
    private Integer number ;

    public Integer getOrder_no() {
        return order_no;
    }

    public void setOrder_no(Integer order_no) {
        this.order_no = order_no;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public Integer getProduct_no() {
        return product_no;
    }

    public void setProduct_no(Integer product_no) {
        this.product_no = product_no;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
