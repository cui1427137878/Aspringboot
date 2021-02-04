package org.spring.ioc;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import com.tedu.mall.RunApp;

//框架的启动类
public class ApplicationContext {
	// 放的是类名
	ArrayList<String> classNameList = new ArrayList<>();
	// 容器
	// userController,对象
	// userServiceImpl,对象
	HashMap<String, Object> container = new HashMap<>();

	public ApplicationContext() throws Throwable {

		classNameList.add("com.tedu.mall.UserController");
		classNameList.add("com.tedu.mall.UserServiceImpl");
		// 创建对象放到容器中
		loadObject();
		System.out.println(container);
		// 处理autowired注解
		autowiredProcess();
	}

	private void loadObject() throws Throwable {
		// 遍历所有的类
		for (String className : classNameList) {

			Class clazz = Class.forName(className);

			// 判断类有没有加@controller或@service
			RestController controller = (RestController) clazz.getAnnotation(RestController.class);
			Service service = (Service) clazz.getAnnotation(Service.class);
			Object object;
			if (controller != null || service != null) {
				object = clazz.newInstance();
				// 得到key
				int begin = className.lastIndexOf(".") + 1;
				// UserController
				className = className.substring(begin);
				// 把首字母变成小写的
				// userController
				String objectName = Character.toLowerCase(className.charAt(0)) + className.substring(1);
				// 创建对象放到容器中
				container.put(objectName, object);
			}

		}

	}

	private void autowiredProcess() throws Throwable {
		// 遍历容器
		for (String key : container.keySet()) {
			// 取到对象，判断对象属性有没有加autowired
			System.out.println("key="+key);
			Object object = container.get(key);
			Class clazz = object.getClass();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				Autowired autowired = field.getAnnotation(Autowired.class);
				if (autowired != null) {
					// @autowired
					// UserService userServiceImpl
					String objectName = field.getName();

					// 从容器中找一个对象赋值给属性
					Object bean = container.get(objectName);

					field.setAccessible(true);
					field.set(object, bean);

				}

			}

		}

	}

	public Object getBean(String beanName) {
		return container.get(beanName);
	}

}
