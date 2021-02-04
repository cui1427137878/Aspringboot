package com.tedu;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcServer {

	public static void main(String[] args) throws Throwable {
		//启动服务器，监听端口号
		ServerSocket serverSocket=new ServerSocket(9091);
		System.out.println("服务器启动了");
		while(true) {
			Socket socket=serverSocket.accept();
			ObjectInputStream objectInputStream=
					new ObjectInputStream
					(socket.getInputStream());
			
			ObjectOutputStream objectOutputStream=
					new ObjectOutputStream(socket.getOutputStream());
		//接收rpc client发过来的数据
			//客户端发送的顺序wireUtf(),wirteUTF(),writeObject(),writeObject()
			//接收的顺序和发送的顺序要一致
			String interfaceName=objectInputStream.readUTF();
			String methodName=objectInputStream.readUTF();
			Object[] clientArgs=(Object[]) 
					objectInputStream.readObject();
			Class[] clientArgsTypes=(Class[])
					objectInputStream.readObject();
		//调用实现类
			Class implClassInfo=UserServiceImpl.class;
			Object implObject=implClassInfo.newInstance();
			Method method=implClassInfo.getMethod(methodName, clientArgsTypes);
			Object result=method.invoke(implObject, clientArgs);
		//把结果返回去
			objectOutputStream.writeObject(result);
			}

	}

}
