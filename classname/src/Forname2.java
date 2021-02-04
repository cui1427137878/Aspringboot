import java.rmi.AccessException;

/**
 * ClassName:Forname2
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Data:2020/10/26 20:10
 * Author:崔建新
 */
public class Forname2 {
    public static void main(String[] args) throws Exception, InstantiationException {
        //通过反射机制，获取Class来获取实例化对象
        Forname3 aa=new Forname3();
         //  Class c = Class.forName("com.tedu.cn.User");
        Class<?> c = Class.forName(aa.test1());
        Object o = c.newInstance();
            System.out.println(o);
       
    }
}
