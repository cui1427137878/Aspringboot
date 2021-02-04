package com.tedu.mall;

import org.spring.aop.ApplicationContext;



public class RunApp {

	public static void main(String[] args) throws Throwable {
		// 启动框架
		ApplicationContext applicationContext = new ApplicationContext();
		UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
		System.out.println(userService.getClass().getName());
		userService.register();

	}

}
