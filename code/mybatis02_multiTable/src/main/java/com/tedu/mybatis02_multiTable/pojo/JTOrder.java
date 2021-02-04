package com.tedu.mybatis02_multiTable.pojo;
//对应jt_order表
public class JTOrder {
//order_id列
	Integer orderId;
	
	//user_id列
	Integer userId;
	
	//用户名在User类
	User user;//订单表和用户表是一对一关系

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
