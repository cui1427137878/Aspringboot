import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//class是个关键字
public class AppMain {

	public static void main(String[] args) {

		//创建目标对象
		UserDAO target=new UserDAO();

		//根据目标得到代理对象
		Object prxoyObject=getProxy(target);
		//类型转换
		IDAO idao=(IDAO) prxoyObject;
		//调用代理对象的方法，框架会调用invocationHanlder的实现类的invoke
		//invoke中执行要重用的代码，再执行目标对象的方法
		idao.select();
		idao.insert();
	}

	// 使用jdk的动态代理框架生成代理对象
	// target指向的是userdao
	public static Object getProxy(IDAO target) {
		// Class是个类 ，类的对象放的是类或接口的方法信息
		// 得到userdao的方法信息,有select(),insert(),
		// 动态类就有select(invocationHandler接口),insert()
		Class[] methodInfo = target.getClass().getInterfaces();
		ClassLoader classLoader = target.getClass().getClassLoader();
		LogInvocationHandler handler = new LogInvocationHandler(target);
		// 生成代理对象，

		// 每1个参数是类加载器
		// 第2个参数是方法信息
		Object proxyObject = Proxy.newProxyInstance(classLoader, methodInfo, handler);
		return proxyObject;
	}

	static class LogInvocationHandler implements InvocationHandler {

		IDAO target;// userdao

		public LogInvocationHandler(IDAO target) {
			super();
			this.target = target;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			//System.out.println("invoke proxy="+proxy.toString());
			//proxy.toString();
			System.out.println("log");
			// 调用目标方法
			// 以前userdao.select()
			System.out.println("invoke 方法名=" + method.getName());
			method.invoke(target, args);
			return null;
		}

	}

}
