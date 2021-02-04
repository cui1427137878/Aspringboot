package com.tedu.springmvc08_itemlist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	
	//返回商品列表
	@RequestMapping("/list")
	//import java.util.List
	public List<Item> list(){
		ArrayList<Item> items=new ArrayList<Item>();
		//Item类要添加构造方法
		items.add(new Item("华为手机", 99999));
		items.add(new Item("小米电视", 888888));
		return items;
	}

}
