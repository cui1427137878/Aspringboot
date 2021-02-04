import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BuyGoodsService;

/**
 * ClassName:MyTest
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Data:2020/11/4 10:44
 * Author:崔建新
 */
public class MyTest {
    @Test
    public void test1(){
        String config="applicationContext1.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        BuyGoodsService service = (BuyGoodsService) ctx.getBean("aa");
        service.buy(1001,1000);
    }
}
