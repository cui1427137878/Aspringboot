package com.tedu.springmvc05_cookie.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	//接收用户名，保存用户名到浏览器中
	@RequestMapping("/login")
	//src/main/java/*Application run as
	//tomcat started on port 1314
	//localhost:1314/login?username=admin
	//在浏览器地址栏url前面有个图标 i，点一下，显示cookie,
	//查看cookie有效期
	public String login(String username,
			HttpServletResponse response) {
		//创建cookie
		Cookie cookie=new Cookie("username", username);
		//用response把cookie返回给浏览器
		response.addCookie(cookie);
		return "保存cookie";
	}

}
