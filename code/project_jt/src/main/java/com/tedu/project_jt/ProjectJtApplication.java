package com.tedu.project_jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//告诉mybatis框架给mapper包中的接口创建代理对象
@MapperScan("com.tedu.project_jt.mapper")
public class ProjectJtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectJtApplication.class, args);
	}

}
