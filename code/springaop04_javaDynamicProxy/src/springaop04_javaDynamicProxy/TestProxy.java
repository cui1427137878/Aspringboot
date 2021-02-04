package springaop04_javaDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {

	public static void main(String[] args) {
		UserDAO target = new UserDAO();
//根据target得到类对象
		Object proxyObject = getProxy(target);
		// 得到代理对象的类对象
		Class clazz = proxyObject.getClass();
		// 通过类对象得到类型
		//// 这个类是我们写的吗？是java动态生成的类
		System.out.println(clazz.getName());
		// 通过类对象得到类的方法
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			// select(){调用invocationHandler.invoke()}
			System.out.println("   " + method.getName());
		}
		// 类型转换
		IDAO userIdao = (IDAO) proxyObject;
		// java运行时生成类$Proxy0.select(){调用InvocationHandler.invoke()}
		Object result = userIdao.select("admin");
		System.out.println(result);
	}

	private static Object getProxy(IDAO target) {

		// 得到目标类的所有接口
		Class[] interfaces = target.getClass().getInterfaces();
		// 得到类加载器
		ClassLoader classLoader = target.getClass().getClassLoader();
		// 创建invocationHandler的对象
		MyHandler myHandler = new MyHandler(target);
		// 调用java生成代理对象
		Object proxyObject = Proxy.newProxyInstance(classLoader, interfaces, myHandler);
		return proxyObject;
	}

	// 1，创建InvocatonHandler的实现类
	static class MyHandler implements InvocationHandler {
		IDAO target;

		// 通过构造方法接收目标类对象
		public MyHandler(IDAO target) {
			super();
			this.target = target;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("invoke");
			// 执行扩展功能
			long startTime = System.nanoTime();
			// 调用目标类
			Object result = method.invoke(target, args);

			return result;
		}

	}

}
