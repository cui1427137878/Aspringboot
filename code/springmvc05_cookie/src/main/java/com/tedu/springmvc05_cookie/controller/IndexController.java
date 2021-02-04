package com.tedu.springmvc05_cookie.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	//保存一个cookie,设置有效期，浏览器关闭还在
	//关闭服务器，重启 tomcat started on port 1314
	//localhost:1314/index    点i图标，查看cookie有效期，关闭浏览器，cookie还在
	@RequestMapping("/index")
	public String index(HttpServletResponse response) {
		Cookie cookie=new Cookie("bd_id", "00001");
		cookie.setMaxAge(60*3);//设置有效期为3分钟
		response.addCookie(cookie);
		return "设置有效期";
	}

}
