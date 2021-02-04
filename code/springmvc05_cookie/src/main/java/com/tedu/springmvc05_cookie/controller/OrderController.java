package com.tedu.springmvc05_cookie.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@RequestMapping("/listOrder")
	//f12 打开浏览器调试器
	//在console中关闭服务器,重启,
	//以前的cookie没了 localhost:1314/login?username=admin
	//localhost:1314/listOrder   
	//network-->request headers   cookie:username=admin
	public String listOrder(HttpServletRequest request) {
		//从request中读取cookie
		Cookie[] cookies=request.getCookies();
		String string="";
		if(cookies!=null) {
			for (Cookie cookie:cookies) {
				String cookieName=cookie.getName();
				String cookieValue=cookie.getValue();
				string=string+cookieName+"="+cookieValue;
			}
		}
		return string;
		
	}

}
