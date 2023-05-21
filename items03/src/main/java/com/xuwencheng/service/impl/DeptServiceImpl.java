package com.xuwencheng.service.impl;

import com.xuwencheng.mapper.DeptMapper;
import com.xuwencheng.pojo.Dept;
import com.xuwencheng.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    /*
    * 查询部门信息
    * */
    @Override
    public List<Dept> select() {
        return deptMapper.listSelect();
    }

    /*
    * 删除部门
    * */
    @Override
    public void remove(Integer id) {
        deptMapper.delete(id);
    }

    /*
    * 添加部门
    * */
    @Override
    public void insert(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insertDept(dept);
    }

    @Override
    public Dept getSelect(Integer id) {
        return  deptMapper.select(id);
    }

    @Override
    public void update(Dept dept) {
        Integer id = dept.getId();
        String name = dept.getName();
        deptMapper.updateDept(name,id);
    }
}
