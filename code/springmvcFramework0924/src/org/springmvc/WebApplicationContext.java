package org.springmvc;

import java.lang.reflect.Method;
import java.util.HashMap;

//��ȫ������
//Context������
public class WebApplicationContext {
	public static HashMap<String, ControllerDefinition>
	urlMapping=new HashMap();
	
	//��ʼ��
	public void init( )throws Throwable{
		//ɨ������controller,
		String[] controllerNames= {"com.tedu.mall.UserController",
				"com.tedu.mall.OrderController"};
		//��������controller
		for (String controllerName:controllerNames) {
		//�õ�controller�����з���
			Class clazz=Class.forName(controllerName);
			Method[] methods=clazz.getDeclaredMethods();
			
		//�������з���
			for (Method method:methods) {
		//�жϷ�����û�м�@requestMapping
				RequestMapping requestMapping=method
						.getAnnotation(RequestMapping.class);
				if (requestMapping!=null) {
		//��url
					String url=requestMapping.value();
		//����controllerDefinition
					boolean isJson=false;
					//�ж�����û�м�@restController
					RestController restController=(RestController) clazz.getAnnotation(RestController.class);
					if (restController!=null) {
						isJson=true;
					}
					ControllerDefinition definition=new ControllerDefinition
							(url, controllerName, method.getName(), isJson);
		//��url,controllerDefinition�ŵ�hashmap��
					urlMapping.put(url, definition);
				}
			}
		}
	}

}
