package com.tedu.springbootproject0821.controller;

import com.tedu.springbootmybatis0821.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/test")
    public  String test(){
        return  sqlSessionFactory.getSqlSession();
    }
}
