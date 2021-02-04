package com.tedu.springmvc09_item.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	// 商品数据
	static ArrayList<String> itemList = new ArrayList<String>();

	@RequestMapping("/insert")
	public String insert(String itemName) {
		itemList.add(itemName);
		return "添加成功";
	}

	@RequestMapping("/select")
	public ArrayList<String> select() {
		return itemList;
	}

	@RequestMapping("/delete")
	public String delete(String itemName) {
		itemList.remove(itemName);
		return "删除成功";
	}

	@RequestMapping("/update")
	public String update(String oldItemName, String newItemName) {
		// 遍历list
		for (int i = 0; i < itemList.size(); i++) {
			// 判断当前的是不是要修改的商品
			if (itemList.get(i).equals(oldItemName)) {
				// 更新list
				itemList.set(i, newItemName);
			}
		}
		return "更改成功";
	}
	//console 显示 tomcat started on port 1314
	//localhost:1314/insert?itemName=mobile
	//localhost:1314/select
	//localhost:1314/delete?itemName=mobile
	//localhost:1314/insert?itemName=mobile
	//localhost:1314/update?oldItemName=mobile&newItemName=phone
	
}
