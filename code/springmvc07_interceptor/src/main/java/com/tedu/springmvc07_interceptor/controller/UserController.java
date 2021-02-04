package com.tedu.springmvc07_interceptor.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	//接收用户名，放在session中
	@RequestMapping("/login")
	public String login(String username,HttpSession session) {
		session.setAttribute("username", username);
		return "登录成功";
	}
}
