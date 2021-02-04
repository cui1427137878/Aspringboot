package com.tedu.springmvc07_interceptor.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//拦截器
public class TimeInterceptor implements HandlerInterceptor {
	// 程序执行顺序preHandle-->controller-->postHandle
	// 在controller方法之前执行,没有提示看讲义的3.1.1
	long startTime;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		startTime = System.nanoTime();// 纳秒
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

//在controller方法之后执行postHandle
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long endTime = System.nanoTime();
		long useTime = endTime - startTime;
//得到用户请求的url
		String url = request.getRequestURI();
		System.out.println(url + "time=" + useTime);
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
}
