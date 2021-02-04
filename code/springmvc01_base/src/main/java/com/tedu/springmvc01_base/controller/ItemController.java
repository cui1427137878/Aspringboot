package com.tedu.springmvc01_base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

	//删除商品
	@RequestMapping("/delete1")
	//localhost:1314/delete1?id=2
	//localhost:1314/delete1     id=null
	//关闭程序，重启
	public String delete1(Integer id) {
		return "id="+id;
	}
	
	@RequestMapping("/delete2")
	//localhost:1314/delete2?id=2
	//localhost:1314/delete2      status=500
	//关闭程序，重启
	public String delete2(int id) {
		//多次访问 this是同一个，单例
		return "id="+id+",this="+this;
	}
}
