package com.tedu;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class UserServlet {

	public static void main(String[] args) {
		Object object = getProxy(UserService.class);
		UserService userService = (UserService) object;
		Object resultObject=userService.login("admin");
		System.out.println(resultObject);
	}

	public static Object getProxy(Class interfaceClassInfo) {
		ClassLoader loader = interfaceClassInfo.getClassLoader();
		Class[] interfaces = { interfaceClassInfo };
		RPCHandler h = new RPCHandler(interfaceClassInfo.getName());
		Object proxyObject = Proxy.newProxyInstance(loader, interfaces, h);
		return proxyObject;
	}

	static class RPCHandler implements InvocationHandler {

		String interfaceName;

		public RPCHandler(String interfaceName) {
			super();
			this.interfaceName = interfaceName;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("invoke");
			//连接上服务器
			Socket socket=new Socket("127.0.0.1", 9091);
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
			//把接口名，方法名，参数，参数类型发给服务器
			objectOutputStream.writeUTF(interfaceName);
			objectOutputStream.writeUTF(method.getName());
			objectOutputStream.writeObject(args);
			objectOutputStream.writeObject(method.getParameterTypes());
			//接收结果
			Object result=objectInputStream.readObject();
			return result;
		}

	}

}
