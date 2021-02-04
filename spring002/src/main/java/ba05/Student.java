package ba05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("student")//只有一个可以自动省略
public class Student {
    /**value为属性赋值**/
    @Value("张飞")
        private String name;
    @Value("22")
        private  int age;
    //当Autowired属性为false，及时名字不对也不报错
   @Autowired(required = false)
   @Qualifier("school")
    private School school;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
