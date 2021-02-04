package ba02;

import ba02.SomeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:MyTest
 * Package:ba01
 * Description:
 *
 * @Data:2020/10/28 10:31
 * Author:崔建新
 */
public class MyTest {
    @Test
    public void test01(){
        String config="applicationContext02.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        ba02.SomeService proxy= (SomeService) ctx.getBean("someService");
        proxy.doOther("张三",20);
//      proxy.doOther("张三");

    }
}
