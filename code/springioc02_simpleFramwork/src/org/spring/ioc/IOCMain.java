package org.spring.ioc;
//模拟spring 框架

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Set;

import com.tedu.UserController;
import com.tedu.UserServiceImpl;

public class IOCMain {
//放对象的容器
	static HashMap<String, Object> container = new HashMap();

	// userServiceImpl,object
	// userController,UserController的对象
	public static void main(String[] args) throws Throwable {
		// 加载对象到容器中
		loadObject();
		// 处理autowired,给属性赋值
		autowiredProcess();
		// 测试UserController的userServiceImpl属性是否有值
		//从容器中的找对象
		UserController userController=(UserController)
				container.get("userController");
		//打印对象的属性
		System.out.println(userController.toString());

	}

	private static void autowiredProcess() throws Throwable {
//遍历hashMap的key
		Set<String> keySet = container.keySet();// 得到集合
		for (String name : keySet) {
			// 根据key得到对象
			Object object = container.get(name);
			// 根据对象得到类对象
			Class clazz = object.getClass();
			// 根据类对象得到所有属性
			Field[] fields = clazz.getDeclaredFields();
			// 遍历所有属性
			for (Field field : fields) {
				// 判断属性是否加了autowired
				Autowired autowired=field.getAnnotation(Autowired.class);
				// 如果加了，从容器中找到对象，赋值
				if (autowired!=null) {
					//field.getName()= userServiceImpl
					Object value=container.get(field.getName());
					field.setAccessible(true);
					field.set(object, value);
				}
			}
		}
	}

	private static void loadObject() {
		UserController userController=new UserController();
		container.put("userController", userController);
		
		UserServiceImpl userServiceImpl=new UserServiceImpl();
		container.put("userServiceImpl", userServiceImpl);
		
	}

}
