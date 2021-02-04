package com.tedu.springmvc10_jsp.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller //不是RestController,
//restController返回的是json或字符串
//controller主要返回jsp，也可以返回json
public class ItemController {
//ModelAndView model业务 View视图 界面
	@RequestMapping("/listItem")
	public ModelAndView listItem() {
		//返回web-inf/jsp/index.jsp
		ModelAndView modelAndView=new ModelAndView("index");
		//往index.jsp中添加数据
		ArrayList<Item> itemList=new ArrayList<Item>();
		itemList.add(new Item("华为手机", 88888));
		itemList.add(new Item("小米电视", 99999));
		modelAndView.addObject("itemList", itemList);
		
		return modelAndView;
		//关闭以前的程序，debug as启动
		//localhost:1314/listItem
	}
	@RequestMapping("/json")
	@ResponseBody//用restController不用加@ResponseBody
	public ArrayList<Item> Json(){
		ArrayList<Item> itemList=new ArrayList<Item>();
		itemList.add(new Item("华为手机", 88888));
		itemList.add(new Item("小米电视", 99999));
		return itemList;
	}
}
