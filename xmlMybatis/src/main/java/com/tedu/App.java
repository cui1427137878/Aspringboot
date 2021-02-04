package com.tedu;

import com.tedu.mapper.ItemMapper;
import com.tedu.pojo.Item;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Throwable
    {
        //1,加载配置文件
        //ibatis.io
        InputStream inputStream= Resources
                .getResourceAsStream("mybatis-config.xml");
        //2,得到sqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder=
                new SqlSessionFactoryBuilder();
        //3,得到SqlSessionFactory
        SqlSessionFactory factory=builder.build(inputStream);
        //4,得到sqlSession
        SqlSession sqlSession=factory.openSession();
        //5,得到connection
        Connection connection=sqlSession.getConnection();
        System.out.println(connection.toString());
        //6.得到接口的代理对象
        ItemMapper itemMapper=sqlSession.getMapper(ItemMapper.class);
        List<Item> itemList = itemMapper.selectByExample(null);
        System.out.println(itemList);

    }
}
