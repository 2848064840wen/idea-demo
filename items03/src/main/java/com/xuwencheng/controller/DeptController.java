package com.xuwencheng.controller;

import com.xuwencheng.pojo.Dept;
import com.xuwencheng.pojo.Result;
import com.xuwencheng.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /*
     * 部门列表的查询
     * */
    @GetMapping
    public Result selectDept() {

        List<Dept> deptList = deptService.select();

        log.info("查询部门信息");

        return Result.success(deptList);
    }


    /*
     * 删除部门
     * */
    @DeleteMapping("/{id}")
    public Result removeDept(@PathVariable Integer id) {

        deptService.remove(id);

        log.info("删除部门：{}", id);

        return Result.success();
    }

    /*
     * 添加部门
     * */
    @PostMapping
    public Result insertDept(@RequestBody Dept dept) {

        deptService.insert(dept);

        log.info("添加部门:{}", dept.getName());

        return Result.success();
    }

    /*
     * 根据id查询部门
     * */
    @GetMapping("/{id}")
    public Result getSelectDept(@PathVariable Integer id) {

        Dept dept = deptService.getSelect(id);

        log.info("根据id查询部门 ： {}", id);

        return Result.success(dept);
    }

    /*
     * 修改部门
     * */
    @PutMapping
    public Result updateDept(@RequestBody Dept dept) {

        deptService.update(dept);

        log.info("修改部门");

        return Result.success();
    }

}
