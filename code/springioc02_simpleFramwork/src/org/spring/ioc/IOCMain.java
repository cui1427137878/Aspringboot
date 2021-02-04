package org.spring.ioc;
//ģ��spring ���

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Set;

import com.tedu.UserController;
import com.tedu.UserServiceImpl;

public class IOCMain {
//�Ŷ��������
	static HashMap<String, Object> container = new HashMap();

	// userServiceImpl,object
	// userController,UserController�Ķ���
	public static void main(String[] args) throws Throwable {
		// ���ض���������
		loadObject();
		// ����autowired,�����Ը�ֵ
		autowiredProcess();
		// ����UserController��userServiceImpl�����Ƿ���ֵ
		//�������е��Ҷ���
		UserController userController=(UserController)
				container.get("userController");
		//��ӡ���������
		System.out.println(userController.toString());

	}

	private static void autowiredProcess() throws Throwable {
//����hashMap��key
		Set<String> keySet = container.keySet();// �õ�����
		for (String name : keySet) {
			// ����key�õ�����
			Object object = container.get(name);
			// ���ݶ���õ������
			Class clazz = object.getClass();
			// ���������õ���������
			Field[] fields = clazz.getDeclaredFields();
			// ������������
			for (Field field : fields) {
				// �ж������Ƿ����autowired
				Autowired autowired=field.getAnnotation(Autowired.class);
				// ������ˣ����������ҵ����󣬸�ֵ
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
