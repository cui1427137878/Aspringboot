package com.tedu;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //启动被整合的第三方框架
        //加载一个jar,反射只能加载一个类
        //加载的jar(框架，服务)要实现Starter
        ServiceLoader<Starter> serviceLoader=
                ServiceLoader.load(Starter.class);
        //加载的是多个服务,遍历每个服务
        Iterator<Starter> iterator=
                serviceLoader.iterator();
        while(iterator.hasNext()) {
            //取出一个服务，启动服务
            Starter service=iterator.next();
            service.start();
        }

    }
}
