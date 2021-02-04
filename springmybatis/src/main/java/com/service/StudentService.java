package com.service;

import domain.Student;

import java.util.List;

/**
 * ClassName:StudentService
 * Package:service
 * Description:
 *
 * @Data:2020/10/29 14:05
 * Author:崔建新
 */
public interface StudentService {
    int insertStudent(Student student);
    List<Student> selectStudent();
}
