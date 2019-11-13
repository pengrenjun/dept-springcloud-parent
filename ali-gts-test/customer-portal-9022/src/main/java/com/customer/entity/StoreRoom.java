package com.customer.entity;

/**
 * @Description 厂库库存信息
 * @Date 2019/5/6 0006 上午 10:45
 * @Created by Pengrenjun
 */
public class StoreRoom {


    private Integer product_no;
    private String  product_name;
    private Integer product_number ;

    public Integer getProduct_no() {
        return product_no;
    }

    public void setProduct_no(Integer product_no) {
        this.product_no = product_no;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getProduct_number() {
        return product_number;
    }

    public void setProduct_number(Integer product_number) {
        this.product_number = product_number;
    }
}
