package com.service;

import com.dao.StudentDao;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:StudentServiceImpl
 * Package:impl.service
 * Description:
 *
 * @Data:2020/10/29 14:08
 * Author:崔建新
 */
@Service("aa")
public class StudentServiceImpl implements StudentService {
  @Autowired
    private StudentDao studentDao;

   /* public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }*/

    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> selectStudent() {
        return studentDao.selectStudent();
    }
}
