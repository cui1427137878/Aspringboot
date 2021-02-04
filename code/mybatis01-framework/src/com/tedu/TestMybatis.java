package com.tedu;

import java.beans.XMLDecoder;
import java.io.InputStream;
import java.util.List;

import org.mybais.configuration.XmlConfigParser;
import org.mybais.executor.SqlSession;

public class TestMybatis {

	public static void main(String[] args) throws Throwable {

		ClassLoader classLoader = TestMybatis.class.getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("mybatis-config.xml");
		XmlConfigParser xmlConfigParser = new XmlConfigParser();
		xmlConfigParser.parser(inputStream);
		
		SqlSession session=new SqlSession();
		Object proxy=session.getMapper(UserMapper.class);
		UserMapper userMapper=(UserMapper) proxy;
		List<User> list =userMapper.findAll();
		System.out.println("main----------");
		System.out.println(list);
	}

}
