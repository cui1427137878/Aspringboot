package com.tedu.jtmall.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.jtmall.mapper.CategoryMapper;
import com.tedu.jtmall.pojo.Category;

@RestController
public class CategoryController {
	//调用mybatis去操作数据库
	@Autowired//从spring ioc容器中取对象
	CategoryMapper categoryMapper;
	
	//接收分类名称，调用categoryMapper
	
	//关闭服务器，重启
	//接收json,有两个要求 1,必须用对象接收， 2,加@requestBody
	@RequestMapping("/cat/insertJson")
	public String insertJson(@RequestBody Category category) {
		int rowCount=categoryMapper.insert(category);
		return "添加成功(json)";
	}
	
	@RequestMapping("/cat/insert")
	//localhost:1314/cat/insert?categoryName=车
	//浏览器显示row=1成功，在sqlyog中刷新category表
	public String insert(String categoryName) {
		//创建实体类
		Category category=new Category();
		category.setCategoryName(categoryName);
		
		//row添加了几行
		int row=categoryMapper.insert(category);
		return "row="+row;
	}
	//查询category商品分类表
	@RequestMapping("/cat/select")
	//localhost:1314/cat/select
	public List<Category> select(){
		//selectByExample(参数是用来设置查询条件的)
		List<Category> list=categoryMapper.selectByExample(null);
		return list;
	}
//修改商品分类
	@RequestMapping("/cat/update")
	//localhost:1314/cat/update?categoryId=5&newCategoryName=车车
	public String update(Integer categoryId,String newCategoryName) {
		//创建对象
		Category category=new Category();
		category.setCategoryId(categoryId);
		category.setCategoryName(newCategoryName);
		//把对象传给接口，mybatis生成sql
		//根据主键修改表
		int rowCount=categoryMapper.updateByPrimaryKey(category);
		return "rowCount="+rowCount;
	}
	//删除
	@RequestMapping("/cat/delete")
	//localhost:1314/cat/delete?categoryId=5
	public String delete(Integer categoryId) {
		//根据主键删除数据
		int rowCount=categoryMapper.deleteByPrimaryKey(categoryId);
		return "rowCount="+rowCount;
	}
	
}
