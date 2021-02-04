package ba02;

import ba02.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:Test01
 * Package:ba01
 * Description:
 *
 * @Data:2020/10/23 16:10
 * Author:崔建新
 */
public class Test02 {
    @Test
    public void test(){
        String config= "applicationContext02.xml";
        ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext(config);
        Student stu= (Student) cp.getBean("student");
        System.out.println(stu);
    }
}
