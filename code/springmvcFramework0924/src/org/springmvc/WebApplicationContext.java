package org.springmvc;

import java.lang.reflect.Method;
import java.util.HashMap;

//放全局数据
//Context上下文
public class WebApplicationContext {
	public static HashMap<String, ControllerDefinition>
	urlMapping=new HashMap();
	
	//初始化
	public void init( )throws Throwable{
		//扫描所有controller,
		String[] controllerNames= {"com.tedu.mall.UserController",
				"com.tedu.mall.OrderController"};
		//遍历所有controller
		for (String controllerName:controllerNames) {
		//得到controller的所有方法
			Class clazz=Class.forName(controllerName);
			Method[] methods=clazz.getDeclaredMethods();
			
		//遍历所有方法
			for (Method method:methods) {
		//判断方法有没有加@requestMapping
				RequestMapping requestMapping=method
						.getAnnotation(RequestMapping.class);
				if (requestMapping!=null) {
		//得url
					String url=requestMapping.value();
		//创建controllerDefinition
					boolean isJson=false;
					//判断类有没有加@restController
					RestController restController=(RestController) clazz.getAnnotation(RestController.class);
					if (restController!=null) {
						isJson=true;
					}
					ControllerDefinition definition=new ControllerDefinition
							(url, controllerName, method.getName(), isJson);
		//把url,controllerDefinition放到hashmap中
					urlMapping.put(url, definition);
				}
			}
		}
	}

}
