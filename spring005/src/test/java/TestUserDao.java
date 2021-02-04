import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

/**
 * ClassName:TestUserDao
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Data:2020/10/24 14:44
 * Author:崔建新
 */
public class TestUserDao {
    @Test
    public  void test() {
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext cs = new ClassPathXmlApplicationContext(config);
        UserService service = (UserService) cs.getBean("service");
        System.out.println(service);
    }
}
