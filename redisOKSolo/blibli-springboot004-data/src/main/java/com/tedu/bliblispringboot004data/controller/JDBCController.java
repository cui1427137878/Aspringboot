package com.tedu.bliblispringboot004data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping("/user")
    public List<Map<String,Object>> user(){
        String sql="select * from goods";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
            return maps;
    }
}
