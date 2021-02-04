package com.tedu.sp01_test.controller;
//controller 控制器
//浏览器-->控制器-->业务service

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//让框架创建对象
@RestController
public class CategoryController {
	//通过url地址访问java中的方法
	//设置地址 request请求 map,hashmap<key,value>key-->value
	//console中关闭服务器，再重启。
	//http://localhost:20001/test
	//http://127.0.0.1:20001/test   5:05
	@RequestMapping("/test")
	public ItemCategory select() {
		ItemCategory itemCategory=new ItemCategory();
		itemCategory.setId(66);
		itemCategory.setName("手机");
		return itemCategory;//框架自动把对象转成json
	}

}
