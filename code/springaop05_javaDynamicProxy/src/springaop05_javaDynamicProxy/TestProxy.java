package springaop05_javaDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {

	public static void main(String[] args) {
		UserDAO target=new UserDAO();//创建目标
		Object proxyObject=getProxy(target);
		
		//测试代理对象的类型
		Class proxyObjectClazz=proxyObject.getClass();//得到代理对象的类对象
		//com.sun.Proxy.$Proxy0
		System.out.println(proxyObjectClazz.getName());
				//测试代理对象的方法
		Method[] methods=proxyObjectClazz.getDeclaredMethods();
		for (Method method:methods) {
			System.out.println(method.getName());
		}
		
		//通过代理对象去调用目标对象的方法
		//$proxy0 implements IDAO ;proxyObject不能转成UserDAO
		Object result=((IDAO)proxyObject).select("admin");
		System.out.println("result="+result);

	}
	//创建代理对象
	private static Object getProxy(IDAO target) {
		//放的是目标类的所有接口的类对象
		Class[] interfaces=target.getClass().getInterfaces();
		//类加载器
		ClassLoader classLoader=target.getClass().getClassLoader();
		//java生成代理类$proxy0{select(){调用接口InvocatoinHandler.invoke}}
		MyHandler myHandler=new MyHandler(target);
		Object proxyObject=Proxy.newProxyInstance
				(classLoader, interfaces, myHandler);
		return proxyObject;
	}
	//静态内部类
	static class MyHandler implements InvocationHandler{

		IDAO target;//目标类的对象
		
		public MyHandler(IDAO target) {
			super();
			this.target = target;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("invoke() 方法名="+method.getName());
			System.out.println("invoke中得时间");
			//调用目标对象的方法
			Object result=method.invoke(target, args);
			return result;
		}
		
	}

}
