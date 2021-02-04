package com.test;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;

public class TestMyBatis extends TestBase {
	@Test
	public void testSqlSessionFactory(){
		SqlSessionFactory factory=
		ctx.getBean("sqlSessionFactory",
				SqlSessionFactory.class);
		System.out.println(factory);
	}
	@Test
	public void testSqlSessionFactoryBean(){
		SqlSessionFactoryBean factoryBean=
				ctx.getBean("&sqlSessionFactory",
						SqlSessionFactoryBean.class);
		System.out.println(factoryBean);
	}
}
