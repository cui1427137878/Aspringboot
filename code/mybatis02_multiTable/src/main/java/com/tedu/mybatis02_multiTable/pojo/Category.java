package com.tedu.mybatis02_multiTable.pojo;
//对应category表

import java.util.List;

public class Category {
	//对应category_id列
	Integer categoryId;
	//对应category_name列
	String categoryName;
	
	//一个分类下有多个商品,是一对多
	List<Item> itemList;
	//生成 set,get

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

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

}
