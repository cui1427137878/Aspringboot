package com.tedu.springmvc10_jsp.controller;

public class Item {
	String itemName;
	int itemPrice;
	public Item(String itemName, int itemPrice) {
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
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	

}
