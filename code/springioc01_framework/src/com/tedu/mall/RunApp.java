package com.tedu.mall;

import org.spring.ioc.ApplicationContext;


public class RunApp {

	public static void main(String[] args) throws Throwable{
		//启动框架
		ApplicationContext applicationContext=
				new ApplicationContext();
		UserController userController=(UserController) applicationContext.getBean("userController");

		System.out.println(userController);
		UserService userService=userController.userServiceImpl;
		userService.register();
	}

}
