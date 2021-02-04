package com.example.mybatis04_plus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.mybatis04_plus.mapper.CategoryMapper;
import com.example.mybatis04_plus.pojo.Category;

@RestController
public class CategoryController {

	@Autowired
	CategoryMapper categoryMapper;
	
	@RequestMapping("/select")
	public List<Category> select(){
		//设置排序
		EntityWrapper<Category> wrapper=new EntityWrapper();
		wrapper.orderBy("category_id desc");
		//调用baseMapper中的selectList()
		return categoryMapper.selectList(wrapper);
	}
}
