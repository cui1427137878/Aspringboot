package com.tedu.springmvc07_interceptor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
	@RequestMapping("/cart")
	public String cart() {
		return "cart";
	}

}
