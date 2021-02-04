package ba04;

/**
 * ClassName:Student
 * Package:org.example
 * Description:
 *
 * @Data:2020/10/22 15:34
 * Author:崔建新
 */
public class Student {
    private String name;
    private int age;
    private School school;
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int  age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ",  age=" +  age +
                ", school=" + school +
                '}';
    }
}
