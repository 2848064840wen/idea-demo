package com.xuwencheng.service;


import com.xuwencheng.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> select();


    void remove(Integer id);

    void insert(Dept dept);

    Dept getSelect(Integer id);

    void update(Dept dept);
}
