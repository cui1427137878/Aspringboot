package com;

import org.mybatis.config.XmlConfigParser;
import org.mybatis.executor.SqlSession;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    public static void main(String[] args) throws  Throwable{

        //加载mybatis-config.xml
        ClassLoader classLoader=TestMybatis.class.getClassLoader();
       InputStream inputStream= classLoader.getResourceAsStream
               ("mybatis-config.xml");
        //调用xmlConfigParser
        XmlConfigParser.parser(inputStream);
        //根据接口得到代理对象
        SqlSession sqlSession=new SqlSession();
        Object proxy=sqlSession.getMapper(UserMapper.class);
        System.out.println(proxy.getClass().getName());
        //通过代理对象执行findAll()
        UserMapper userMapper= (UserMapper) proxy;
        List<User> list=userMapper.findAll();
        System.out.println("main:");
        System.out.println(list);


    }
}
