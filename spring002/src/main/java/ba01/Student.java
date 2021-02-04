package ba01;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * ClassName:Student
 * Package:ba01
 * Description:
 *
 * @Data:2020/10/23 15:32
 * Author:崔建新
 */
//最正统的 @Component(value = "student")
//@Component//自动名字是类名第一个字母小写
@Component("student")//只有一个可以自动省略
public class Student {
    private String name;
    private  int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
