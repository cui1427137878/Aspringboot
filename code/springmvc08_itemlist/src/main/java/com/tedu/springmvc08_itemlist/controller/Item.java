package com.tedu.springmvc08_itemlist.controller;
//商品
public class Item {
	//商品名称
	String itemName;
	//商品价格9.58  958
	Integer itemPrice;
	
	public Item(String itemName, Integer itemPrice) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

}
