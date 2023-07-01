package com.lzhapi.service;

import com.lzhapi.model.Student;

public interface StudentService {

    Student queryStu(Integer id);

    int addStu(Student student);

}
