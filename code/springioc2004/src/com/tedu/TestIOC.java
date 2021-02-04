package com.tedu;

import org.springioc.ApplicationContext;

public class TestIOC {
    public static  void main(String[] args) throws  Throwable
    {
        ApplicationContext applicationContext=new ApplicationContext();
        //从框架中取一个对象
        Object object=applicationContext.getBean("userController");
        UserController userController= (UserController) object;
        userController.login();
    }
}
