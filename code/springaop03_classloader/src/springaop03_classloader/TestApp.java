package springaop03_classloader;

import java.io.IOException;
import java.io.InputStream;

public class TestApp {

	public static void main(String[] args) throws Throwable {
		//TestApp类必须由类加载器把类的方法加载到方法区
		//创建对象
		TestApp testApp=new TestApp();
		//得到类对象
		Class clazz=testApp.getClass();//TestApp.class也可以
		//根据类对象得到类的加载器
		ClassLoader classLoader=clazz.getClassLoader();
		System.out.println(classLoader);
		
		//读取文件用java.io.File(d:\*\config.txt)
		
		//通过类加载器读取文件，得到输入流
		InputStream inputStream=classLoader
				.getResourceAsStream("config.txt");
		//得到流的长度
		int length=inputStream.available();// main() throws Throwable
		//创建byte[]
		byte[] data=new byte[length];
		//把输入流的内容读到byte[]
		inputStream.read(data);
		//把byte[]转成字符串
		String proxyName=new String(data);
		System.out.println(proxyName);
		
		//使用类加载器加载类
		//得到类对象有4种方式
		//1.类名.class  2,object.getClass()  3,Class.forName()
		//4,类加载器.loadClass()
		Class proxyClazz=classLoader.loadClass(proxyName);
		Object proxyObject=proxyClazz.newInstance();
		System.out.println(proxyObject);

	}

}
