package com.tedu.mall;

import javax.http.HttpServletResponse;

import org.springmvc.Controller;
import org.springmvc.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/login")
	public HttpServletResponse login() {
		HttpServletResponse response=new HttpServletResponse();
		response.setResponseBody("login �ɹ�");
		return response;
	}
	
	@RequestMapping("/register")
	public HttpServletResponse register() {
		HttpServletResponse response=new HttpServletResponse();
		response.setResponseBody("register �ɹ�");
		return response;
	}
}
