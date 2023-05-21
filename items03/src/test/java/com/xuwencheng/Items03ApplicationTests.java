package com.xuwencheng;

import com.xuwencheng.service.DeptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Items03ApplicationTests {

    @Autowired
    private DeptService deptService;
    @Test
    void contextLoads() {
    }

    @Test
    void test01(){
        System.out.println(deptService.select());
        System.out.println(deptService.select());
        System.out.println(deptService.select());
        System.out.println(deptService.select());
    }
}
