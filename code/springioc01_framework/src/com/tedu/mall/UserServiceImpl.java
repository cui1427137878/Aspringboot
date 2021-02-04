package com.tedu.mall;

import org.spring.ioc.Service;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public void register() {
		System.out.println("register()");
		
	}

}
