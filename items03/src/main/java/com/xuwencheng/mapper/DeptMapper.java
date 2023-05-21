package com.xuwencheng.mapper;

import com.xuwencheng.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    //查询部门信息
    List<Dept> listSelect();

    //删除部门
    void delete(Integer id);

    //添加部门
//    @Insert("insert into dept (name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insertDept(Dept dept);

    Dept select(Integer id);

    void updateDept(String name,Integer id);

}
