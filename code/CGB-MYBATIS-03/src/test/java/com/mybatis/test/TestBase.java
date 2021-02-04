package com.mybatis.test;
import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;


public class TestBase {
    protected SqlSessionFactory factory;
    @Before
	public void init() throws IOException {
		String resource="mybatis-configs.xml";
		factory=new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream(resource));
	}
}
