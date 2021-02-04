package com.tedu.springioc01_userService.service;

import org.springframework.stereotype.Service;

//业务层，创建对象交给spring框架
@Service //告诉spring框架，我是业务层，spring会自动创建对象
public class UserServiceImpl implements UserService{

	@Override
	public String register() {
		return "业务层注册成功";
	}

}
