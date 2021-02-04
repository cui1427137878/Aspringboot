package com.tedu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
//模拟实现jdk的动态代理框架
public class Proxy {
public static void main(String[] args) throws Exception {
	Object proxyObject=newProxyInstance();
	System.out.println("根据接口生成的代理对象"+proxyObject.toString());
}
//newProxyInstance (InvocatinHandler handler,Class)
public static  Object newProxyInstance () throws Exception
{
	//读取接口的抽象方法
	Class interfaceInfo=IDAO.class;
	Method[] methods=interfaceInfo.getMethods();
	for (Method method:methods)
	{
		System.out.println(method.getName());
	}
	//save
	String method1Name=methods[0].getName();
	//select
	String method2Name=methods[1].getName();

	//根据抽象方法生成Proxy1.java
	//代理类中的save方法{调用接口invocationHandler.invoke方法，再调用目标对象方法save}
	//用我们写的代理框架，在调用代理对象.save()时，传InvocationHandler实现类，传用目标对象
	//接口中的方法个数不固定
	//stringBuilder.append(public class Proxy1{)
	//for (Methods){stringBuilder.append(方法)}
	String classContent="public class Proxy1{"
			+ "public void "+method1Name+"() {} "
			+ "public void "+method2Name+"() {}}";
	String javaFile="d:\\2005\\Proxy1.java";
	FileWriter fileWriter=new FileWriter(javaFile);
	fileWriter.write(classContent);
	fileWriter.flush();
	//动态编译出一个Proxy1.class
	JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
	StandardJavaFileManager manager=compiler.getStandardFileManager(null, null, null);

	File file=new File(javaFile);
	Iterable units=manager.getJavaFileObjects(file);
	CompilationTask task= compiler.getTask(null, manager, null, null, null, units);
	task.call();//D:/2005/Proxy1.class
	//加载类，创建对象
	ProxyClassLoader classLoader=new ProxyClassLoader();
	String classFile="D://2005//Proxy1.class";
	Class classInfo=classLoader.findClass(classFile);
	Object proxy=classInfo.newInstance();
	
	return proxy;
	}

   static class ProxyClassLoader extends ClassLoader
   {
	   @Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			FileInputStream fileInputStream=new FileInputStream(name);
			int length=fileInputStream.available();
			byte[] content=new byte[length];
			fileInputStream.read(content);
			return defineClass(content, 0, length);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	   
   }
}
