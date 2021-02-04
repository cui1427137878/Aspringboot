package org.springmvc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

	//ѡ��Throwable F3 ��Դ�� F4�鿴Throwable�ĸ��������
	public static void main(String[] args) throws Throwable{
		//com.tedu�Ǹ��ļ��У�ͨ��java.io.File.listFiles()
		//com/tedu/ItemController -->com.tedu.ItemController
		String[] classNames= {"com.tedu.UserController",
				"com.tedu.ItemController"};
		for(String className:classNames) {
//�Զ������������˽������
			//�õ������
			Class clazz=Class.forName(className);
			//��������
			Object object=clazz.newInstance();
			
			Field[] fields=clazz.getDeclaredFields();
			for (Field field:fields) {
				//����˽������Ϊ�ɷ��ʵ�
				field.setAccessible(true);
				//�����Ը�ֵ
				field.set(object, 18);
			}
		//�Զ�ִ��������ķ���
			Method[] methods=clazz.getDeclaredMethods();
			System.out.println(className);
			for (Method method:methods) {
				System.out.println("   "+method.getName());
				method.invoke(object);
			}
		}
	}

}
