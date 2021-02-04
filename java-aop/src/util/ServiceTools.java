package util;

import java.util.Date;

/**
 * ClassName:ServiceTools
 * Package:util
 * Description:
 *
 * @Data:2020/10/24 16:21
 * Author:崔建新
 */
public class ServiceTools {
    public static void doTime(){
        System.out.println("方法的执行时间"+new Date());
    }
    public static void doC(){
        System.out.println("方法执行完毕后，提交事务");
    }
}
