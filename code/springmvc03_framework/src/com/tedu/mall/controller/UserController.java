package com.tedu.mall.controller;

import javax.http.HttpServletResponse;

import org.springmvc.Controller;
import org.springmvc.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/register")
	public HttpServletResponse register() {
		HttpServletResponse response=new HttpServletResponse();
		response.setResponseBody("register success");
		return response;
	}
	@RequestMapping("/login")
	public HttpServletResponse login() {
		HttpServletResponse response=new HttpServletResponse();
		response.setResponseBody("login success");
		return response;
	}
}
