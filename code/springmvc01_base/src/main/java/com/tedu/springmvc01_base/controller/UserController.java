package com.tedu.springmvc01_base.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@RequestMapping("/register1")
	//http://localhost:1314/register1?username=admin&password=root
	//get请求  url?参数名称=值&参数名称=值&参数名称=值
	//src/main/java/*Application run as 
	//console 显示 tomcat started on port 1314
	public String register1(String username,String password) {
		return "username="+username+",password="+password;
	}

	//给方法传参数，参数很多。创建一个类
	@RequestMapping("/register2")
	// http://localhost:1314/register2?username=root&password=root
	//console 点个红色按钮，关闭以前的程序，
	//再重启 tomcat started on port 1314
	public String register2(User user) {
		return "register2 username="+user.getUsername()
		+"password="+user.getPassword();
	}
	@RequestMapping("/register3")
	//localhost:1314/register3?username=admin&password=root
	public String register3(HttpServletRequest request) {
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String ip=request.getRemoteAddr();
		return "register3 name="+name+",password="+password
				+"ip="+ip;
		
	}
	
	@RequestMapping("/register4")
	//localhost:1314/register3?username=admin&password=root
	public void register4(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String ip=request.getRemoteAddr();
		String result= "register3 name="+name+",password="+password
				+"ip="+ip;
		//用response返回结果
		//告诉浏览器返回的是html
		response.setContentType("text/html");
		//设置字符集
		response.setCharacterEncoding("UTF-8");
		//返回内容
		PrintWriter printWriter=response.getWriter();
		printWriter.println(result);		
	}
	
	
	
	
	
}
