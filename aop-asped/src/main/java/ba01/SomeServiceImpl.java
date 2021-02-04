package ba01;


/**
 * ClassName:SomeServiceImpl
 * Package:ba01
 * Description:
 *
 * @Data:2020/10/28 9:47
 * Author:崔建新
 */
public class SomeServiceImpl implements SomeService {


    public void doSome(String name, int age) {
        System.out.println("===目标方法 dosome()===");
    }

    public String doOther(String name) {
        return name;
    }
}
