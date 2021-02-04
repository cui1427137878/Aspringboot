package com.tedu.springbootmybatis0821;

public class SqlSessionFactory {
    public SqlSessionFactory(){
        System.out.println("sqlSessionFactory");
    }

    public String getSqlSession()
    {
        return  "sqlSession 0821";
    }
}
