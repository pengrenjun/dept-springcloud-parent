package com.orderform.mapper;

import com.orderform.entity.OrderForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description:  订单数据库操作接口
 * @Author：pengrj
 * @Date : 2018/12/19 0019 23:32
 * @version:1.0
 */
@Mapper //Mybatis与springboot整合必须加上这个注解 springboot才能识别
public interface OrderMapper {

    /**
     * 订购商品
     * @return
     */
    boolean order(OrderForm orderForm);

    //@Select("select order_no,order_name,product_no,number from storeroom;")
    List<OrderForm> list();

}
