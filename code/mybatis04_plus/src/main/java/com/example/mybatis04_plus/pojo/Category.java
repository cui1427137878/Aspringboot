package com.example.mybatis04_plus.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

//对应category表
//实现映射,以前是在CategoryMapper.xml中实现
@TableName("category")
public class Category {
	//映射到category_id列
	//以前是在xml中写result column=category_id property=categoryId
	@TableField("category_id")
	Integer categoryId;
	
	@TableField("category_name")
	String categoryName;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
