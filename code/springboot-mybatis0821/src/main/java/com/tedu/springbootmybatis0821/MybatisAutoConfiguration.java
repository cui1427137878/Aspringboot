package com.tedu.springbootmybatis0821;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@EnableConfigurationProperties(MybatisProperties.class)
@Configuration
public class MybatisAutoConfiguration {
    @Resource
    MybatisProperties mybatisProperties;

@Bean
    public SqlSessionFactory sqlSessionFactory()
    {
        System.out.println(mybatisProperties.getUrl());
        SqlSessionFactory factory=new SqlSessionFactory();
        return  factory;
    }
}
