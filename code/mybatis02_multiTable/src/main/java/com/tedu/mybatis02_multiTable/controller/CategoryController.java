package com.tedu.mybatis02_multiTable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.mybatis02_multiTable.mapper.CategoryMapper;
import com.tedu.mybatis02_multiTable.pojo.Category;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryMapper categoryMapper;
	
	@RequestMapping("/cat")
	//localhost:1314/cat
	public Category cat() {
		return categoryMapper.selectCategory(1);
	}

}
