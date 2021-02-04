package com.tedu.sp04orderservice.controller;

import java.util.Arrays;

import com.tedu.pojo.JsonResult;
import com.tedu.pojo.Order;
import com.tedu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/{orderId}")
	public JsonResult getOrder(@PathVariable Integer orderId) {
		Order order = orderService.getOrder(orderId);
		return new JsonResult(0,"ok",order);
	}
}