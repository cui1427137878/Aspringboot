package ba02;


import org.springframework.stereotype.Component;

/**
 * ClassName:SomeServiceImpl
 * Package:ba01
 * Description:
 *
 * @Data:2020/10/28 9:47
 * Author:崔建新
 */
@Component("someService")
public class SomeServiceImpl implements SomeService {

    @Override
    public void doSome(String name, int age) {
        System.out.println("===目标方法 dosome()===");
    }

    @Override
    public String doOther(String name, int age) {
        System.out.println("这是doOther方法");

        return "abcd";
    }

    @Override
    public Student doOther2(String name, int age) {
        Student student =new Student();
        student.setAge(20);
        student.setName("张三");
        return student;
    }

}
