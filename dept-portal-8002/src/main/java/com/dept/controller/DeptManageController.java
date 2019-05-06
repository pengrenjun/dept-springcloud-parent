package com.dept.controller;

import entity.Dept;
import microservice.url.DeptMircServiceUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Description: 部门管理服务类 调用部门微服务接口（Ribbon template方式）进行信息的处理
 * @Author：pengrj
 * @Date : 2018/12/24 0024 20:59
 * @version:1.0
 */

@RestController
public class DeptManageController {


    @Autowired
    private RestTemplate restTemplate;



    @RequestMapping(value = "/deptManage/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
        //<T> T postForObject(URI url, Object request, Class<T> responseType) throws RestClientException;
        return restTemplate.postForObject(DeptMircServiceUrl.DEPT_ADD,dept,Boolean.class);
    }

    @RequestMapping(value = "/deptManage/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") String  id)
    {
        return restTemplate.getForObject(DeptMircServiceUrl.Dept_Getdept_ById_URL(id),Dept.class);
    }

    @RequestMapping(value = "/deptManage/list", method = RequestMethod.GET)
    public List<Dept> list()
    {
        return restTemplate.getForObject(DeptMircServiceUrl.DEPT_GETDEPT_LIST,List.class);
    }





}
