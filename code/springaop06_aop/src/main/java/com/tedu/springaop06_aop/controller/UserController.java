package com.tedu.springaop06_aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.springaop06_aop.service.UserService;

@RestController
public class UserController {
	//调用业务层，从spring 容器中得对象
	@Autowired //ioc
	UserService userService;
	@RequestMapping("/register")
	public String register(String username) {
		//调用业务层
		String result=userService.register(username);
		return result;
	}

}
