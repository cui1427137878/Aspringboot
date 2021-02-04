package cn.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.pojo.User;
import cn.tedu.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	@RequestMapping("/findAll")
	public  List<User> findAll()
	{
	
		return userService.findAll();
	}
	
	//springmvc传递对象参数时，无需加注解
		@RequestMapping("/insert/{name}/{birthday}/{address}")
		public String insert(User user){
			try{
				userService.insert(user);
				return "insert success.";
			}catch(Exception e){
				e.printStackTrace();
				return "insert error.";
			}
		}
}
