package com.tedu.mall;

import org.springmvc.RequestMapping;
import org.springmvc.RestController;

@RestController
public class OrderController {

	@RequestMapping("/order")
	public Order select() {
		Order order=new Order();
		order.setOrderId(900);
		order.setTotal(10000);
		return order;
	}
}
