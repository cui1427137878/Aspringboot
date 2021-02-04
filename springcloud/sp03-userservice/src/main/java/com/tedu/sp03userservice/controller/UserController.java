package com.tedu.sp03userservice.controller;

import com.tedu.pojo.JsonResult;
import com.tedu.pojo.User;
import com.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{userId}")
	public JsonResult getUser(@PathVariable Integer userId) {
		User user = userService.getUser(userId);
		return new JsonResult(0,"ok",user);
	}
	
	
}