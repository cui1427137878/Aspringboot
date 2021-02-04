package org.springmvc;

import com.tedu.UserController;

//springmvc框架启动时执行
public class Main {

	public static void main(String[] args) {
		//判断类有没有加RestController
		//.class返回来一个对象 类对象
		//new ArrayList 数组集合
		//类对象 包含属性和方法， 访问私有属性，执行方法，判断有没有加注解
		Class clazz=UserController.class;
		//如果加上自动创建对象
		RestController restController=(RestController) clazz
				.getAnnotation(RestController.class);
		if (restController!=null) {
			//加了注解
			UserController userController=new UserController();
			System.out.println(userController);
			//删除UserController上的@restController
		}

	}

}
