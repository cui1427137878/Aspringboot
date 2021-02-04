package com.tedu;

public class UserServiceImpl implements UserService{

	@Override
	public String login(String username) {
		
		return "server login run username="+username;
	}

	@Override
	public String register(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
