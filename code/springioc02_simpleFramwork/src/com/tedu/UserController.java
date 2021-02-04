package com.tedu;

import org.spring.ioc.Autowired;

public class UserController {
//需要业务层对象
	@Autowired
	UserServiceImpl userServiceImpl;
}
