package com.tedu.mybatis02_multiTable.mapper;
//操作category表

import com.tedu.mybatis02_multiTable.pojo.Category;

public interface CategoryMapper {
	//查询分类和分类下的商品
	
	public Category selectCategory(Integer categoryId);

}
