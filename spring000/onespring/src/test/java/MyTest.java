import javafx.application.Application;
import org.example.App;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:MyTest
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Data:2020/10/21 15:29
 * Author:崔建新
 */
public class MyTest {
    @Test
    public void test() {
        SomeServiceImpl service = new SomeServiceImpl();
        service.doDome();
    }
    @Test
    public void test1(){
      String config="bean.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService service =(SomeService) ac.getBean("aa");
        App app =(App) ac.getBean("app");
        service.doDome();
        app.tes();
    }
    @Test
    public void test2(){
        String config="bean.xml";
        ClassPathXmlApplicationContext sc = new ClassPathXmlApplicationContext(config);
        int i = sc.getBeanDefinitionCount();
        System.out.println(i);
        String[] name = sc.getBeanDefinitionNames();
        for (String names:name
             ) {
            System.out.println(names);
            
        }
    }
}
