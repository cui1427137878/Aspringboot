package com.tedu.jtmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tedu.jtmall.mapper")
//mapper接口scan扫描，注解的作用告诉mybatis,接口的位置
public class Mybatis01CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Mybatis01CrudApplication.class, args);
	}

}
