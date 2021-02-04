package com.tedu.springmvc11_page.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	//根据日期查询订单
	// /order/2020-01-01/2020-01-10
	@RequestMapping("/order/{startDate}/{endDate}")
	public String searchByDate(@PathVariable String startDate,
			@PathVariable String endDate) {
		return "rest ful startDate="+startDate+",endDate="+endDate;
	}
}
