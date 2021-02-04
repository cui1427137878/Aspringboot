package com.tedu.springioc01_userService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.springioc01_userService.service.UserService;

@RestController
public class UserController {
	//需要业务层的对象，对象由spring框架提供
	//面向对象-->面向接口编程-->无侵入式
	//对象的类型是接口，面向接口编程
	@Autowired
	UserService userService;
	
	@RequestMapping("/register")
	public String register() {
		//调业务层
		String result=userService.register();
		//返回结果给浏览器
		return result;
	}

}
