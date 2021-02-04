package com.tedu.mybatis03_dynamicsql.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.mybatis03_dynamicsql.mapper.ItemMapper;
import com.tedu.mybatis03_dynamicsql.pojo.Item;

@RestController
public class ItemController {
	
	//从spring ioc的容器中获取代理对象	
	@Autowired
	ItemMapper itemMapper;
	
	@RequestMapping("/item")
	public List<Item> select(Item item){
		
		return itemMapper.select(item);
	}
	
	@RequestMapping("/list")
	public List<Item> list(){
		ArrayList<Integer> idList=new ArrayList<Integer>();
		idList.add(2);
		idList.add(3);
		return itemMapper.list(idList);
	}

}
