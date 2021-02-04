package org.mybais.executor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.mybais.configuration.Configuration;
import org.mybais.configuration.SqlMapper;
import org.mybais.configuration.XmlConfigParser;

public class MapperProxy implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoke");
		String methodName=method.getName();
		System.out.println("methodName="+methodName);
		//从XmlConfigParser.configuration得到url,driver,username,password
		//1,创建连接
		Configuration configuration=XmlConfigParser.configuration;
		String driver=configuration.getDriver();
		Class.forName(driver);
		Connection connection=DriverManager.getConnection
				(configuration.getUrl(),
						configuration.getUsername(),
						configuration.getPassword());
		System.out.println(connection);
		//2,读取数据库
		//2.1 得到id
		String interfaceName=method.getDeclaringClass().getName();
		String id=interfaceName+"."+methodName;
		System.out.println("id="+id);
		//2.2 从configuration.hashmap中根据id得到 sqlMapper
		SqlMapper sqlMapper=configuration.getSqlMappers().get(id);
		
		//2.3 得到 sql
		String sql=sqlMapper.getSql();
		System.out.println("sql="+sql);
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		ResultSet resultSet=preparedStatement.executeQuery();
		//3,读到表的列名id,username
		List<Object> list=new ArrayList();
		while(resultSet.next()) {			
			//4,读到每行数据
			ResultSetMetaData metaData=resultSet.getMetaData();
			int columnCount=metaData.getColumnCount();
			//把每行的数据转成一个对象
			
			//com.tedu.user
			String returnClassName=sqlMapper.getResultType();
			Class clazz=Class.forName(returnClassName);
			Object object=clazz.newInstance();
			for (int col=1;col<=columnCount;col++) {
				String columnName=metaData.getColumnLabel(col);
				Object dbValue=resultSet.getObject(columnName);
				System.out.println(columnName+":"+dbValue);
				
				//用反射给属性赋值
				Field field=clazz.getDeclaredField(columnName);
				field.setAccessible(true);
				field.set(object, dbValue);
			}
			System.out.println(object);
			list.add(object);

		}
		return list;
	}

}
