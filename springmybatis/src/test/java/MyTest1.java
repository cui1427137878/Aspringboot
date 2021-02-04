import com.dao.StudentDao;
import com.service.StudentService;
import domain.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * ClassName:MyTest
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Data:2020/10/29 15:43
 * Author:崔建新
 */

public class MyTest1 {
    @Test
    public void test01(){
    String config="applicationContext1.xml";
      ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        String[] name = ctx.getBeanDefinitionNames();
        for(String na:name){
            System.out.println("容器中对象名称"+na);
        }
    }
    @Test
    public void test02(){
        String config="applicationContext1.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        String[] name = ctx.getBeanDefinitionNames();
        StudentDao dao= (StudentDao) ctx.getBean("studentDao");
        Student student=new Student(2001,"哎哎","22222",30);
         int nums=dao.insertStudent(student);
        System.out.println(nums);
    }
    @Test
    public void test03(){
        String config="applicationContext1.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentService service1= (StudentService) ctx.getBean("aa");
        Student student=new Student(20,"哎哎","22222",30);
        int nums=service1.insertStudent(student);
        System.out.println(nums);
    }
    @Test
    public void test04(){
        String config="applicationContext1.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentService service1= (StudentService) ctx.getBean("aa");
        List<Student> students = service1.selectStudent();
        for(Student student:students){
            System.out.println(student);
        }



    }
}
