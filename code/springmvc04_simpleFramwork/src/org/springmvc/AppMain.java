package org.springmvc;
//springmvc的入口类

import java.lang.reflect.Method;
import java.util.HashMap;

public class AppMain {
//  /register  ,controllerDefinition[url,UserController,register]
	static HashMap<String, ControllerDefinition> urlMapping = new HashMap();

	// /register,[/register,UserController,register]
	// /login,[/login,UserController,login]
	public static void main(String[] args) throws Throwable{
		// 加载类
		loadObjects();
		// 处理请求
		requestProcess("/register");
		requestProcess("/login");

	}

	private static void requestProcess(String url) throws Throwable {
		//1,从urlMapping找到一个controllerDefinition
		ControllerDefinition definition=urlMapping.get(url);
		//2,得到类名，方法名
		String className=definition.getClassName();
		String methodName=definition.getMethodName();
		//3,根据类名，得到类对象
		Class clazz=Class.forName(className);		
		//4,通过类对象创建对象
		Object object=clazz.newInstance();
		//5,根据方法名称，得到一个方法
		Method method=clazz.getDeclaredMethod(methodName);
		//6,调用这个方法
		Object result=method.invoke(object);
		System.out.println(url+":"+result);

	}

	private static void loadObjects() throws Throwable {
		String className = "com.tedu.UserController";
		// 得到类对象
		Class clazz = Class.forName(className);
		// 判断有没有加@RestController
		RestController restController = (RestController) clazz.getAnnotation(RestController.class);
		if (restController != null) {
			// 得到所有方法
			Method[] methods = clazz.getDeclaredMethods();
			// 遍历所有方法
			for (Method method : methods) {
				// 判断方法有没有加@requestMapping
				RequestMapping requestMapping = method.getAnnotation
						(RequestMapping.class);
				if (requestMapping != null) {
					// 如果加上，得url
					String url=requestMapping.value();
					// 创建controllerDefinition
					String methodName=method.getName();
					ControllerDefinition definition=new 
							ControllerDefinition(url, className, methodName);
					// 把url,controllerDefinition放到hashmap中
					urlMapping.put(url, definition);
				}
			}
		}

	}

}
