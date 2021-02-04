package ba02;

/**
 * ClassName:Student
 * Package:ba02
 * Description:
 *
 * @Data:2020/10/28 19:26
 * Author:崔建新
 */
public class Student {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
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
