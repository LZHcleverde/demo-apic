package com.lzhp.mapper;


import com.lzhapi.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {

    //查询手机号
    Student queryPhone(@Param("phone") String phone);


    //添加数据
    int insertStu(Student student);


    //查询id
    Student selectById(@Param("id") Integer id);



}
