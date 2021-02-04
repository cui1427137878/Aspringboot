package com.tedu.sp03userservice.service;
import com.tedu.pojo.User;
import com.tedu.service.UserService;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
	@Override
	public User getUser(Integer id) {
		User user=null;
		if (id==1){
			user=new User(1,"马云","123456");
		}
		if (id==2){
			user=new User(2,"马化腾","168");
		}
		return user;
	}



}