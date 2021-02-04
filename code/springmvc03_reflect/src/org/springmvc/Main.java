package org.springmvc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

	//选中Throwable F3 打开源码 F4查看Throwable的父类和子类
	public static void main(String[] args) throws Throwable{
		//com.tedu是个文件夹，通过java.io.File.listFiles()
		//com/tedu/ItemController -->com.tedu.ItemController
		String[] classNames= {"com.tedu.UserController",
				"com.tedu.ItemController"};
		for(String className:classNames) {
//自动访问所有类的私有属性
			//得到类对象
			Class clazz=Class.forName(className);
			//创建对象
			Object object=clazz.newInstance();
			
			Field[] fields=clazz.getDeclaredFields();
			for (Field field:fields) {
				//设置私有属性为可访问的
				field.setAccessible(true);
				//给属性赋值
				field.set(object, 18);
			}
		//自动执行所有类的方法
			Method[] methods=clazz.getDeclaredMethods();
			System.out.println(className);
			for (Method method:methods) {
				System.out.println("   "+method.getName());
				method.invoke(object);
			}
		}
	}

}
