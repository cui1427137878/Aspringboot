package com.tedu.mall;

import org.spring.ioc.Autowired;
import org.spring.ioc.RestController;

@RestController
public class UserController {

	@Autowired
	UserService userServiceImpl;
}
