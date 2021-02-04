package ba02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component("student")//只有一个可以自动省略
public class Student {
    /**value为属性赋值**/
    @Value("张飞")
        private String name;
    @Value("22")
        private  int age;
    @Override
        public String toString() {
            return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
