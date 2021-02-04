package dao;

import org.springframework.stereotype.Repository;

/**
 * ClassName:UserDaoImpl
 * Package:dao
 * Description:
 *
 * @Data:2020/10/24 14:32
 * Author:崔建新
 */
@Repository
public class UserDaoImpl implements UserDao {
    public void s() {
        System.out.println("操作数据库");
    }
    public String toString() {
        String name="操作数据库";
        return name;
    }
}
