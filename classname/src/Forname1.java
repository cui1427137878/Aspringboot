import org.junit.Test;

import java.util.Date;

/**
 * ClassName:Forname1
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Data:2020/10/26 19:12
 * Author:崔建新
 */
public class Forname1 {
    public static void main(String[] args) {
        Object c1 = null;
        Class c2 = null;
        //第一种方式 Class.forName
        try {
            c1 = Class.forName("java.lang.String");
            c2 = Class.forName("java.util.Date");
            Class<?> c3 = Class.forName("java.lang.Integer");
            Class<?> c4 = Class.forName("java.lang.System");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //第二种方式 a.getClass
        String s = "abc";
        Class<? extends String> x = s.getClass();
        if(x==c1){
            System.out.println("aaa");
        System.out.println(x == c1);}
        Date time = new Date();
        Class y = time.getClass();
        if (c2 == y)
            System.out.println(c2 == y);
        //第三种方式，基本数据类型都有.class属性

    }
    @Test
    public void test() throws ClassNotFoundException {
        Class<?> test1 = Class.forName("Test1");
        Class<?> test2 = Class.forName("Test2");
        Class<Test2> testClass = Test2.class;
        Class<Test> testClass1 = Test.class;
        System.out.println(testClass);
        System.out.println(testClass1);

        System.out.println(test1==test2);
    }
}