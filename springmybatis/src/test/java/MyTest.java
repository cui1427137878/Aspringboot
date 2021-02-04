import com.dao.StudentDao;
import com.service.StudentService;
import domain.Student;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.ws.Service;

/**
 * ClassName:MyTest
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Data:2020/10/29 15:43
 * Author:崔建新
 */


public class MyTest {
    @Test
    public void test01(){
    String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        String[] name = ctx.getBeanDefinitionNames();
        for(String na:name){
            System.out.println("容器中对象名称"+na);
        }
    }
    @Test
    public void test02(){
        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentDao dao= (StudentDao) ctx.getBean("stu");
        Student student=new Student(2888,"哎哎","22222",30);
        int nums=dao.insertStudent(student);
        System.out.println(nums);
    }
    @Test
    public void test03(){
        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentService service1= (StudentService) ctx.getBean("aa");
        Student student=new Student(167,"enen","22222",30);
        int nums=service1.insertStudent(student);
        System.out.println(nums);
    }
}
