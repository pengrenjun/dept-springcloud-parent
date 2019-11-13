package com.customer.service;

import com.customer.entity.StoreRoom;
import com.google.common.net.HttpHeaders;
import com.google.common.net.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2019/5/6 0006 下午 2:22
 * @Created by Pengrenjun
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private RestTemplate restTemplate;

    //微服务在eureka注册的实例名称 Ribbon配置结合eureka实现根据微服务的实例名称查找服务
    //订单
    private static   final String REST_ORDER_PREURL="http://ORDERFORM.SERVICE";
    //库存
    private static   final String REST_STROREROOM_PREURL="http://STOREROOM.SERVICE";

    //库存商品列表信息获取
    private static   final String REST_STROREROOM_LIST=REST_STROREROOM_PREURL+"/storeroom/list";

    //去库存
    private static   final String REST_STROREROOM_REDUCE=REST_STROREROOM_PREURL+"/storeroom/reduce";

    //生成订单
    private static   final String REST_OEDER_ADD=REST_ORDER_PREURL+"/orderform/order";

    private boolean  flag=true;



    /**
     * 模拟分布式事务情况 先减少库存数据 再生成订单
     * @param product_no
     * @param product_number
     * @return
     */

    @Override
    public boolean orderProduct(@RequestParam  Integer product_no, @RequestParam  Integer product_number) {
            //扣库存
            String url= REST_STROREROOM_REDUCE+"?product_no="+product_no+"&product_number="+product_number;
            restTemplate.getForEntity(url, Integer.class);

            Map<String ,Object> variables=new HashMap<>();
            variables.put("product_no",product_no);
            variables.put("product_number",product_number);
            //生成订单
            restTemplate.postForObject(REST_OEDER_ADD,variables,Boolean.class);
            return flag;
    }

    @Override
    public List<StoreRoom> getProductList() {
        List<StoreRoom> forObject = restTemplate.getForObject(REST_STROREROOM_LIST, List.class);
        return forObject;
    }
}
