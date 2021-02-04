package org.spring.aop;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;

import com.tedu.mall.RunApp;
import com.tedu.mall.TimeAspect;
import com.tedu.mall.UserServiceImpl;

//框架的启动类
public class ApplicationContext {
	// 放的是类
	// 容器
	// userController,对象
	// userServiceImpl,对象
	HashMap<String, Object> container = new HashMap<>();

	public ApplicationContext() throws Throwable {
		UserServiceImpl userServiceImpl=new UserServiceImpl();
		container.put("userServiceImpl", userServiceImpl);
		
		TimeAspect timeAspect=new TimeAspect();
		container.put("timeAspect", timeAspect);
	
		

		// 遍历容器中所有的对象
		for (String key : container.keySet()) {
			// 判断这个对象有没有加@Aspect
			Object object = container.get(key);
			Class clazz = object.getClass();
			Aspect aspect = (Aspect) clazz.getAnnotation(Aspect.class);
			if (aspect != null) {
				Object aspectObject = object;
				// 在执行目标类UserServiceImpl的目标方法register时，自动执行timeAspect
				// 找到pointcut,before,after
				String pointcutString = null;
				Method beforeMethod = null;
				Method afterMethod = null;

				// 遍历TimeAspect的所有方法
				Method[] methods = aspectObject.getClass().getDeclaredMethods();
				for (Method method : methods) {
					Pointcut pointcut = method.getAnnotation(Pointcut.class);
					Before before = method.getAnnotation(Before.class);
					After after = method.getAnnotation(After.class);
					if (pointcut != null) {
						pointcutString = pointcut.value();
					}
					if (before != null) {
						beforeMethod = method;
					}
					if (after != null) {
						afterMethod = method;
					}
				}
				// pointcutString=com.tedu.mall.UserServiceImpl.register
				// 得到key userServiceImpl;从容器中找到目标类的对象
				String[] strings = pointcutString.split("\\.");
				String targetObjectkey = strings[strings.length - 2];
				targetObjectkey = Character.toLowerCase(targetObjectkey.charAt(0)) + targetObjectkey.substring(1);
				// 得到目标类对象，创建动态代理对象proxy
				Object targetObject = container.get(targetObjectkey);

				Class[] interfaces = targetObject.getClass().getInterfaces();
				ClassLoader loader = targetObject.getClass().getClassLoader();
				AopHandler aopHandler = new AopHandler(targetObject, beforeMethod, afterMethod, aspectObject);
				Object proxy = Proxy.newProxyInstance(loader, interfaces, aopHandler);

				// 容器中userServiceimpl原先的对象是用反射创建的对象，改成proxy
				// userServiceImpl,
				container.put(targetObjectkey, proxy);
				// 程序员从容器中取对象，取到的是proxy,proxy.register()
			}
		}

	
	}

	

	class AopHandler implements InvocationHandler {
		Object targetObject;// UserServiceImpl
		Method beforeMethod;
		Method afterMethod;
		Object aspectObject;

		public AopHandler(Object targetObject, Method beforeMethod, Method afterMethod, Object aspectObject) {
			super();
			this.targetObject = targetObject;
			this.beforeMethod = beforeMethod;
			this.afterMethod = afterMethod;
			this.aspectObject = aspectObject;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			// 调用切面的before
			if (beforeMethod != null)
				beforeMethod.invoke(aspectObject);
			// 调用目标方法UserServiceImpl.register
			method.invoke(targetObject, args);
			// 调用切面的after
			if (afterMethod != null)
				afterMethod.invoke(aspectObject);
			return null;
		}

	}

	public Object getBean(String beanName) {
		return container.get(beanName);
	}

	
}
