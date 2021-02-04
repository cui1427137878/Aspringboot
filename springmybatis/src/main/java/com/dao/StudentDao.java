package com.dao;

import domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName:StudentDao
 * Package:dao
 * Description:
 *
 * @Data:2020/10/29 10:34
 * Author:崔建新
 */
@Repository("stu")
public interface StudentDao {
    int insertStudent(Student student);
    List<Student> selectStudent();
}
