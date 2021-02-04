package com.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBase {
	/**
	 * 借助此对象创建SqlSession(通过此对象
	 * 实现与数据库之间的会话)
	 */
	protected SqlSessionFactory factory;
    /**
     * 此方会在@Test注解修饰的方法之前执行,
     * 通常用于做一些初始化操作(方法名自己定义)
     */
	@Before
	public void init()throws IOException{
		//所有框架都有配置(xml,annotation,properties,...)
		//1)对于文件需要实用IO进行读取
		//2)对于注解需要借助反射进行读取
		InputStream in=Resources.getResourceAsStream("mybatis-configs.xml");
		//InputStream in=getClass().getClassLoader().getResourceAsStream("mybatis-configs.xml");
		//假如是读取文件获取了流对象，后续需要对流对象中的内容进行读取和解析
		//1)SqlSessionFactoryBuilder对象底层会首先借助xml解析器对流进行相关解析
		//2)SqlSessionFactoryBuilder对象会对解析内容进行封装
		factory=new SqlSessionFactoryBuilder().build(in);
		//系统底层建造者模式构建工厂对象(此对象构建过程相对复杂)
	}
	@Test
	public void testSqlSessionFactory(){
		//测试factory是否不等于null
		Assert.assertNotEquals(
				null,//unexpected
				factory);//断言测试
		//假如factory不等于null则输出factory的值
		System.out.println(factory);
	}
	
	
}





