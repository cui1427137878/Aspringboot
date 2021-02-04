package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName:UserService
 * Package:service
 * Description:
 *
 * @Data:2020/10/24 14:35
 * Author:崔建新
 */
@Service("service")
public class UserService {
   @Resource
   private UserDao userDaoImpl;

   @Override
   public String toString() {
      return "UserService{" +
              "userDao=" + userDaoImpl+
              '}';
   }
}
