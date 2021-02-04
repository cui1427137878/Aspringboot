package com.tedu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tedu.item.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RedisController {
    //读取配置文件中的信息
    @Value("${redis.host}")
    String host;
    @Value("${redis.port}")
    String port;

    //读取redis数据
    @RequestMapping("/get")
    public Map<String,String> get(){
        Jedis jedis=new Jedis(host, Integer.parseInt(port));
        Map<String,String> map=jedis.hgetAll("itemList");
        jedis.close();
        return map;

    }
    //像redis添加数据
    @RequestMapping("/insert")
    public String insert() throws Throwable{
        //redis连接数据库
        
        Jedis jedis=new Jedis(host, Integer.parseInt(port));
        //创建两个商品
        Item item1=new Item("1001","mate10");
        Item item2=new Item("1002","mate20");
        //用jackson吧对象转化成json对象，redis不可能放对象
        ObjectMapper objectMapper=new ObjectMapper();
        String item1Json=objectMapper.writeValueAsString(item1);
        String item2Json=objectMapper.writeValueAsString(item2);
        //把商品放到hashMap
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("1001",item1Json);
        hashMap.put("1002",item2Json);
        //把hashMap放到redis中
        jedis.hmset("itemList",hashMap);
        jedis.close();
        return "ok";
    }
}
