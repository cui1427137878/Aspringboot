package com.tedu.springmvc07_interceptor.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置参数
@Component //组件，作用像RestController,加上后框架会自动创建对象
public class WebConfig implements WebMvcConfigurer{
	//告诉框架，我们有那些拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		AuthInterceptor authInterceptor=new AuthInterceptor();
		registry.addInterceptor(authInterceptor)
		.addPathPatterns("/order","/cart");

		TimeInterceptor timeInterceptor=new TimeInterceptor();
		registry.addInterceptor(timeInterceptor)
		.addPathPatterns("/**");
		//pathPattens访问所有url都执行timeInterceptor
		WebMvcConfigurer.super.addInterceptors(registry);
		//关闭,启动程序
		//localhost:1314/login
		//localhost:1314/order
		//localhost:1314/cart
		//console打印时间
	}

}
