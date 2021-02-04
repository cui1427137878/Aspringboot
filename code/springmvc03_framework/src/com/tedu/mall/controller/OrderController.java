package com.tedu.mall.controller;

import org.springmvc.RequestMapping;
import org.springmvc.RestController;

@RestController
public class OrderController {

	@RequestMapping("/getOrder")
	public OrderEntity getOrder() {
		OrderEntity orderEntity = new OrderEntity("202008120001", 9000);
		return orderEntity;
	}
}
