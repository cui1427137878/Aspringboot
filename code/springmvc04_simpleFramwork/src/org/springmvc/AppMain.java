package org.springmvc;
//springmvc�������

import java.lang.reflect.Method;
import java.util.HashMap;

public class AppMain {
//  /register  ,controllerDefinition[url,UserController,register]
	static HashMap<String, ControllerDefinition> urlMapping = new HashMap();

	// /register,[/register,UserController,register]
	// /login,[/login,UserController,login]
	public static void main(String[] args) throws Throwable{
		// ������
		loadObjects();
		// ��������
		requestProcess("/register");
		requestProcess("/login");

	}

	private static void requestProcess(String url) throws Throwable {
		//1,��urlMapping�ҵ�һ��controllerDefinition
		ControllerDefinition definition=urlMapping.get(url);
		//2,�õ�������������
		String className=definition.getClassName();
		String methodName=definition.getMethodName();
		//3,�����������õ������
		Class clazz=Class.forName(className);		
		//4,ͨ������󴴽�����
		Object object=clazz.newInstance();
		//5,���ݷ������ƣ��õ�һ������
		Method method=clazz.getDeclaredMethod(methodName);
		//6,�����������
		Object result=method.invoke(object);
		System.out.println(url+":"+result);

	}

	private static void loadObjects() throws Throwable {
		String className = "com.tedu.UserController";
		// �õ������
		Class clazz = Class.forName(className);
		// �ж���û�м�@RestController
		RestController restController = (RestController) clazz.getAnnotation(RestController.class);
		if (restController != null) {
			// �õ����з���
			Method[] methods = clazz.getDeclaredMethods();
			// �������з���
			for (Method method : methods) {
				// �жϷ�����û�м�@requestMapping
				RequestMapping requestMapping = method.getAnnotation
						(RequestMapping.class);
				if (requestMapping != null) {
					// ������ϣ���url
					String url=requestMapping.value();
					// ����controllerDefinition
					String methodName=method.getName();
					ControllerDefinition definition=new 
							ControllerDefinition(url, className, methodName);
					// ��url,controllerDefinition�ŵ�hashmap��
					urlMapping.put(url, definition);
				}
			}
		}

	}

}
