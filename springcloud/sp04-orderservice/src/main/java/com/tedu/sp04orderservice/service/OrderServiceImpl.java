package com.tedu.sp04orderservice.service;

import com.tedu.pojo.Order;
import com.tedu.service.OrderService;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public Order getOrder(Integer orderId) {
		//TODO: 调用user-service获取用户信息
		//TODO: 调用item-service获取商品信息
		Order order = new Order(orderId,null,null);
		order.setId(orderId);
		return order;
	}



}