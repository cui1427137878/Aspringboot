package com.tedu.springmvc07_interceptor.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//判断用户有没有登录，如果没有登录显示login.html
		//如果登录成功，继续执行controller,postHandle
		
		//从request中得到session
		HttpSession session=request.getSession();
		//从session中取用户名
		String username=(String) session.getAttribute("username");
		//判断username是否为空
		//stringUtils是org.springframwork.util包中
		if (StringUtils.isEmpty(username)) {
			//为空，用户没有登录，通知浏览器显示login.html
			response.sendRedirect("/login.html");
			return false;//不执行controller,postHandle
		}
		
		return true;//true:执行preHandle后继续执行controller和postHandle
		//false:不执行controller和postHandle
	}

}
