package com.lzhp.service.impl;

import com.lzhapi.model.Student;
import com.lzhapi.service.StudentService;
import com.lzhp.mapper.StudentMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@DubboService(interfaceClass = StudentService.class,version = "1.0.0")
public class StudentServiceImpl implements StudentService {
    //git
    //源码
    @Resource
    private StudentMapper studentMapper;


    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public Student queryStu(Integer id) {
        System.out.println("Git");
        final String USER_KEY = "STUDENT:";
        Student student = null;
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Student.class));

        ValueOperations opsForValue = redisTemplate.opsForValue();
        if(id != null){
            student = (Student) opsForValue.get(USER_KEY+id);
            System.out.println(student);
            //redis没有，就从数据库查询，并且添加到数据库中
            if(student == null){
                System.out.println("redis中没有student");
                //从mybatis查询
                student = studentMapper.selectById(id);
                if(student != null){
                    System.out.println("mysql中有student");
                    opsForValue.set(USER_KEY+id,student);
                }else {
                    System.out.println("mysql中没有student");
                    opsForValue.set(USER_KEY+id,new Student());
                }
            }else {
                System.out.println("redis中有student");
            }
        }
        return student;
    }

    /**
     *
     * @param student
     * @return 1: 添加成功
     *          2:手机号重复
     *          3:没有手机号
     */
    @Override
    public int addStu(Student student) {

        int result = 0;

        //查询手机号，唯一
        if(student.getPhone() != null){
            Student stu = studentMapper.queryPhone(student.getPhone());
            if(stu != null){
                result = 2;
            }else {
                //添加
                result = studentMapper.insertStu(student);
            }
        }else {
            result = 3;
        }
        return result;
    }
}
