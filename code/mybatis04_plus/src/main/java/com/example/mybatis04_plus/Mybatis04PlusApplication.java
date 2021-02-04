package com.example.mybatis04_plus;

import java.lang.reflect.Method;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.mybatis04_plus.pojo.User;

@SpringBootApplication
@MapperScan("com.example.mybatis04_plus.mapper")
public class Mybatis04PlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(Mybatis04PlusApplication.class, args);
		
		//测试User类有没有set(),get()
		User user=new User();
		user.setUserId(6688);
		System.out.println(user.getUserId());
		
		Class clazz=User.class;
		Method[] methods=clazz.getDeclaredMethods();
		for (Method method:methods) {
			System.out.println(method.getName());
		}
	}

}
