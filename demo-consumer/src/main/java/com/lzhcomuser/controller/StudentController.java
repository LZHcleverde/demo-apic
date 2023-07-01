package com.lzhcomuser.controller;


import com.lzhapi.model.Student;
import com.lzhapi.service.StudentService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StudentController {


    @DubboReference(version = "1.0.0")
    private StudentService studentService;

    @PostMapping("/student/add")
    public String addStu(Student student){

        int result = studentService.addStu(student);
        String msg = "请稍后";

        if(result == 1){
            msg = "添加" + student.toString() + "添加成功";
        }else if(result == 2){
            msg = "手机号重复";
        }else {
            msg = "手机号不存在";
        }

        return msg;
    }



    @GetMapping("/student/query")
    public String queryById(Integer id){
        String msg = "请稍后";
        if(id != null && id > 0){
            Student student = studentService.queryStu(id);
            System.out.println(student);
            if(student != null){
                System.out.println("controller 有学生信息");
                msg = "学生信息"+student.toString();
            }else {
                msg = "学生不存在";
            }
        }else {
            msg = "id不正确";
        }
        return msg;
    }


}
