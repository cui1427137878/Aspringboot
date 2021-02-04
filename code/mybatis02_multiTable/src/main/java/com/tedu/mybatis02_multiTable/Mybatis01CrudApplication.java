package com.tedu.mybatis02_multiTable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tedu.mybatis02_multiTable.mapper")
public class Mybatis01CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Mybatis01CrudApplication.class, args);
	}

}
