package org.mybais.executor;

import java.lang.reflect.Proxy;

public class SqlSession {
	public Object getMapper(Class clazz) {
		ClassLoader classLoader=clazz.getClassLoader();
		Class[] interfaces= {clazz};
		MapperProxy mapperProxy=new MapperProxy();
		
		return Proxy.newProxyInstance(classLoader, interfaces, mapperProxy);
	}

}
