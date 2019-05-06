package com.dept.feigncontroller;

import entity.Dept;
import microservice.deptfeign.DeptFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: 部门管理服务类 调用部门微服务接口(Feign接口方式)进行信息的处理
 * @Author：pengrj
 * @Date : 2018/12/24 0024 20:59
 * @version:1.0
 */

@RestController
public class DeptManageFeignController {



    @Autowired
    private DeptFeignService deptFeignService;



    @RequestMapping(value = "/deptManage/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
        //<T> T postForObject(URI url, Object request, Class<T> responseType) throws RestClientException;
        return deptFeignService.add(dept);
    }

    @RequestMapping(value = "/deptManage/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") String  id)
    {
        return deptFeignService.get(id);
    }

    @RequestMapping(value = "/deptManage/list", method = RequestMethod.GET)
    public List<Dept> list()
    {
        return deptFeignService.list();
    }




}
