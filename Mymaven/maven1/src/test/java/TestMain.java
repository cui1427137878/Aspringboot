import com.tedu.cn.DeptDao;
import org.junit.Test;


/**
 * ClassName:TestMain
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Data:2020/10/20 11:31
 * Author:崔建新t;
 */
public class TestMain {
   @Test
    public  void myTest(){
        DeptDao dao=new DeptDao();
        try {
            dao.findDept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
