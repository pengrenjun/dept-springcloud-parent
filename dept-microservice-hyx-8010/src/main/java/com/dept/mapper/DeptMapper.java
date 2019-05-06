package com.dept.mapper;

import entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description:  部门数据库操作接口
 * @Author：pengrj
 * @Date : 2018/12/19 0019 23:32
 * @version:1.0
 */
@Mapper //Mybatis与springboot整合必须加上这个注解 springboot才能识别
public interface  DeptMapper {
    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();

}
