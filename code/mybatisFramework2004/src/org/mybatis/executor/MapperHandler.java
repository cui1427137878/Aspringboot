package org.mybatis.executor;

import org.mybatis.config.Configuration;
import org.mybatis.config.SqlMapper;
import org.mybatis.config.XmlConfigParser;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;

public class MapperHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       System.out.print("invoke method="+method.getName());
        ArrayList list=new ArrayList();
       //1,根据method得到id com.UserMapper.findAll
        String methodName=method.getName();
        String className=method.getDeclaringClass().getName();
        String id=className+"."+methodName;

        //2,从xmlConfigParser中得到configuration
        Configuration configuration= XmlConfigParser.configuration;
        //3,从configuration中取出driver,url,username,password
        String driver=configuration.getDriver();
        String url=configuration.getUrl();
        String username=configuration.getUsername();
        String password=configuration.getPassword();
        //4,从configuration.SqlMappers中取出sqlMapper
        SqlMapper sqlMapper=configuration.getSqlMappers().get(id);
        //5,连接数据库
            //5.1加载驱动
        Class.forName(driver);
            //5.2创建连接
        Connection connection= DriverManager.getConnection(url,username,password);
        //6,从sqlMapper中取出sql
        String sql=sqlMapper.getSql();
        //7,执行sql
        PreparedStatement statement=connection.prepareStatement(sql);
        //8,结果集
        ResultSet resultSet=statement.executeQuery();
        //9,遍历行
        int row=0;
        while(resultSet.next()) {
            row++;
            //9.1创建User对象
            String resultType=sqlMapper.getResultType();
            Class clazz=Class.forName(resultType);
            Object entity=clazz.newInstance();
            //9.2得到列数
            ResultSetMetaData metaData=resultSet.getMetaData();
            int columnCount=metaData.getColumnCount();
            //9.3遍历列
            for (int columnIndex=1;columnIndex<=columnCount;columnIndex++) {
                String columnName=metaData.getColumnName(columnIndex);
                //根据列名创建field
                Field field=clazz.getDeclaredField(columnName);
                //给field赋值
                field.setAccessible(true);
                //取出当前行当前列的值
                Object dbValue=resultSet.getObject(columnName);
                field.set(entity,dbValue);
            }
            System.out.println("row="+row+":"+entity.toString());
            //9.4把user对象放到list
            list.add(entity);
        }
        //10返回list<user>
        return list;
    }
}
