package com.tedu.mybatis03_dynamicsql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tedu.mybatis03_dynamicsql.mapper")
//mybatis框架扫描mapper包下的所有接口，为接口创建动态代理对象
public class Mybatis03DynamicsqlApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(Mybatis03DynamicsqlApplication.class, args);
	}

}
