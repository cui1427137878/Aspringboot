package com.test;
import javax.sql.DataSource;
import org.junit.Test;
import com.alibaba.druid.pool.DruidDataSource;
public class TestDataSource extends TestBase {
	@Test
	public void testDataSource()throws Exception{
		DataSource dataSource=
		ctx.getBean("dataSource",DruidDataSource.class);
		System.out.println(dataSource.getConnection());
	}
}
