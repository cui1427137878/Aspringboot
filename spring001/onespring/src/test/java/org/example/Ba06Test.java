package org.example;

import ba06.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:MyTest
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Data:2020/10/21 15:29
 * Author:崔建新
 */
public class Ba06Test {
    @Test
    public void test(){
        String config= "ba06/bean6.xml";
        ClassPathXmlApplicationContext sc = new ClassPathXmlApplicationContext(config);
        Student student = (Student) sc.getBean("student");
        System.out.println(student);
    }
}
