package com.tedu.cn;

import handler.MyIncationHandler;

import java.lang.reflect.Proxy;

/**
 * ClassName:com.tedu.cn.MyApp
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Data:2020/10/24 16:08
 * Author:崔建新
 */
public class MyApp {
    public static void main(String[] args) {
        /*老版的调用*/
//       SomeServiceImpl service = new SomeServiceImpl();
//        service.doSome();
//        System.out.println("=======");
//        service.doOther();
        /*新版的使用动态添加,使用jdk的proxy*/
//       目标类
        Service target=new SomeServiceImpl();
//        代理类
        MyIncationHandler handler = new MyIncationHandler(target);
        Service proxy = (Service) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
        proxy.doSome();
        proxy.doOther();

    }
}
