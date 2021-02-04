package com.tedu.mybatis02_multiTable.pojo;
//对应item表
public class Item {
//对应category_id列
	Integer categoryId;
	//对应item_name列
	String itemName;
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
}
