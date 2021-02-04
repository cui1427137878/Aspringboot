package com;

import org.springaop.ApplicationContext;

public class TestAOP {
    public static void main(String[] args) throws  Throwable{
        //1,启动框架
        ApplicationContext context=new ApplicationContext();
        //2,从框架中得到一个对象
        Object object=context.getBean("userServiceImpl");
        System.out.println(object.getClass().getName());
        //3,调用对象的方法
        UserService service= (UserService) object;
        service.login();
    }
}
