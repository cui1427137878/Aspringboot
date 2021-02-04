package com.tedu.springmvc11_page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //不是restController
public class UserController {
	
	//原先的登录地址
	@RequestMapping("/login")
	public String login() {
		//5.12.2 地址栏中输入localhost:1314/login,地址栏中的地址变了吗？
		return "redirect:https://passport.jd.com/new/login.aspx";
	}
	//只接收用户名和密码
	@RequestMapping("/up")
	@ResponseBody
	public String usernameAndPwd(String username,String pwd) {
		return username+":"+pwd;
	}
	//接收用户名和密码和验证码
	@RequestMapping("/code")
	public String usernameAndPwdAndCode(String username
			,String pwd
			,String code) {
		//判断验证码正确
		//用转发forware调用/up
		return "forward:/up";
	}

}
