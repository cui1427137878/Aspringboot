package com.tedu;

import org.springmvc.RequestMapping;
import org.springmvc.RestController;

@RestController
public class UserController {
	@RequestMapping(value = "/register")
	public String register() {
		return "注册成功";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "登录成功";
	}

}
