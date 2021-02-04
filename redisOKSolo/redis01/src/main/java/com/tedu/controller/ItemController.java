package com.tedu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tedu.mapper.ItemMapper;
import com.tedu.pojo.Item;
import com.tedu.pojo.ItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.List;

@RestController
public class ItemController {
    @Value("${redis.host}")
    String host;
    @Value("${redis.port}")
    String port;
    @Autowired
    ItemMapper itemMapper;

    //查数据
    @RequestMapping("/selectById")
    public Item get(Integer itemId) throws Throwable{
        //先从redis中查数据，查不到，在去数据库里
        Jedis jedis=new Jedis(host, Integer.parseInt(port));
        //k-v存储,先看是否查得到
        String json=jedis.get(String.valueOf(itemId));
        if(StringUtils.isEmpty(json)==false){
            //转化
            ObjectMapper objectMapper=new ObjectMapper();
            Item item=objectMapper.readValue(json,Item.class);
            jedis.close();
            return item;
        }
        ItemExample itemExample=new ItemExample();
        ItemExample.Criteria criteria = itemExample.or();
        criteria.andItemIdEqualTo(itemId);
        List<Item> itemList= itemMapper.selectByExample(itemExample);
        return itemList.get(0);
    }

    @RequestMapping("/item/insert")
    public String insert(Integer itemId) throws  Throwable{
        //1,从mysql中查询商品
        //1.1 创建example生成where orderby
        ItemExample itemExample=new ItemExample();
        //1.2 创建criteria生成where itemId=1
        ItemExample.Criteria criteria=itemExample.or();
        criteria.andItemIdEqualTo(itemId);
        //1.3使用接口的代理对象执行sql
        List<Item> itemList=itemMapper.selectByExample(itemExample);
        //1.4从集合中取到一件商品
        Item item=itemList.get(0);
        //2,把商品保存到redis中
        //2.1判断有没有取到商品
        if (item!=null) {
            //2.2连接redis
            Jedis jedis=new Jedis(host,Integer.parseInt(port));
            //2.3 用jackson把对象转成字符串
            ObjectMapper objectMapper=new ObjectMapper();
            String json=objectMapper.writeValueAsString(item);
            //2.4 调用set()把字符串保存到redis
            String result=jedis.set(String.valueOf(itemId),json);
            //2.5 关闭连接
            jedis.close();
            return result;
        }
        return "failure";
    }
}
