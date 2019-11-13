package com.dept.controller;

import com.dept.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:  部门服务对外接口
 * @Author：pengrj
 * @Date : 2018/12/19 0019 23:34
 * @version:1.0
 */

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;


    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "deptGetHystrixCommand")
    public Dept get(@PathVariable("id") Long id)
    {
        Dept dept=deptService.get(id);
        //部门为空 抛出异常 进行熔断处理
        if(dept==null){
            throw  new RuntimeException("部门ID:"+id+" 的部门查询不到数据");
        }
        return dept;
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list()
    {
        return deptService.list();
    }

    /*熔断处理 返回处理的数据*/
    private Dept  deptGetHystrixCommand (@PathVariable("id") Long id){
        return new Dept("asd","adcasd");
    }


}
