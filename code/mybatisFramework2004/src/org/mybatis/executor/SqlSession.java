package org.mybatis.executor;

import java.lang.reflect.Proxy;

public class SqlSession {
    //返回接口的代理对象
    public Object getMapper(Class clazz){
        ClassLoader classLoader=clazz.getClassLoader();
        Class[] interfaces={clazz};
        MapperHandler mapperHandler=new MapperHandler();
        return Proxy.newProxyInstance(classLoader,interfaces,mapperHandler);
    }
}
