package org.springmvc;

import java.lang.reflect.Method;
import java.util.HashMap;

public class WebApplictionContext {
	// /register,{/register,UserController,register,false}
	// /login,{/login,UserController,login,false}
	public static HashMap<String, ControllerDefinition> UrlMapping = new HashMap<>();

	public void init() throws Throwable {
		// 扫描所有的controller
		String[] controllerNames = { "com.tedu.mall.controller.UserController" ,
				"com.tedu.mall.controller.OrderController"};
		for (String controllerName : controllerNames) {
			Class clazz = Class.forName(controllerName);
			// 得到所有方法
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				// 判断方法有没有加requestMapping注解
				RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
				if (requestMapping != null) {
					// 得到url
					String url = requestMapping.value();
					// 创建ControllerDefinition
					String methodName = method.getName();
					boolean isJson = false;
					//判断这个类有没有加@restController
					RestController restController=(RestController) clazz.getAnnotation(RestController.class);
					if (restController!=null) {
						isJson=true;
					}
					ControllerDefinition controllerDefinition = new ControllerDefinition(url, controllerName,
							methodName, isJson);
					// 把controllerDefinition放到UrlMapping
					UrlMapping.put(url, controllerDefinition);
				}
			}
		}
	}
}
