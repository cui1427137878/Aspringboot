package com.tedu.springaop06_aop.service;

import org.springframework.stereotype.Service;

//业务层实现类
@Service //让spring创建一个对象，对象放在spring的容器中
public class UserServiceImpl  implements UserService{

	@Override
	public String register(String username) {		
		return username+"注册成功了";
	}

}
