package com.tdu;

import handler.MyHandler;

import java.lang.reflect.Proxy;

public class Test1 {
    public static void main(String[] args) {
        Service di=new ServiceImpl();
        MyHandler handler=new MyHandler(di);
        Service o = (Service) Proxy.newProxyInstance(di.getClass().getClassLoader(), di.getClass().getInterfaces(), handler);
        o.doSome();

    }
}
