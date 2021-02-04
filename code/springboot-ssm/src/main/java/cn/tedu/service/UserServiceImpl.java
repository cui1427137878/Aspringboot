package cn.tedu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.mapper.UserMapper;
import cn.tedu.pojo.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	public List<User> findAll()
	{
		return userMapper.findAll();
	}
	public void insert(User user){
		userMapper.insert(user);
	}
}
