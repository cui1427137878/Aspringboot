package com.tedu.springmvc07_interceptor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@RequestMapping("/order")
	public String order() {
		return "order";
	}

}
