package springaop04_javaDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {

	public static void main(String[] args) {
		UserDAO target = new UserDAO();
//����target�õ������
		Object proxyObject = getProxy(target);
		// �õ��������������
		Class clazz = proxyObject.getClass();
		// ͨ�������õ�����
		//// �����������д������java��̬���ɵ���
		System.out.println(clazz.getName());
		// ͨ�������õ���ķ���
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			// select(){����invocationHandler.invoke()}
			System.out.println("   " + method.getName());
		}
		// ����ת��
		IDAO userIdao = (IDAO) proxyObject;
		// java����ʱ������$Proxy0.select(){����InvocationHandler.invoke()}
		Object result = userIdao.select("admin");
		System.out.println(result);
	}

	private static Object getProxy(IDAO target) {

		// �õ�Ŀ��������нӿ�
		Class[] interfaces = target.getClass().getInterfaces();
		// �õ��������
		ClassLoader classLoader = target.getClass().getClassLoader();
		// ����invocationHandler�Ķ���
		MyHandler myHandler = new MyHandler(target);
		// ����java���ɴ������
		Object proxyObject = Proxy.newProxyInstance(classLoader, interfaces, myHandler);
		return proxyObject;
	}

	// 1������InvocatonHandler��ʵ����
	static class MyHandler implements InvocationHandler {
		IDAO target;

		// ͨ�����췽������Ŀ�������
		public MyHandler(IDAO target) {
			super();
			this.target = target;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("invoke");
			// ִ����չ����
			long startTime = System.nanoTime();
			// ����Ŀ����
			Object result = method.invoke(target, args);

			return result;
		}

	}

}
