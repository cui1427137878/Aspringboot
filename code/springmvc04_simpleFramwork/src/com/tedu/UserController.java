package com.tedu;

import org.springmvc.RequestMapping;
import org.springmvc.RestController;

@RestController
public class UserController {
	@RequestMapping(value = "/register")
	public String register() {
		return "ע��ɹ�";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "��¼�ɹ�";
	}

}
