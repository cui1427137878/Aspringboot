package com.tedu.mybatis02_multiTable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.mybatis02_multiTable.mapper.JTOrderMapper;
import com.tedu.mybatis02_multiTable.pojo.JTOrder;

@RestController
public class OrderController {
	
	//从框架获取一个代理对象
	@Autowired
	JTOrderMapper jtOrderMapper;
	
	@RequestMapping("/order")
	//localhost:1314/order?orderId=1
	public JTOrder select(Integer orderId) {
		JTOrder jtOrder=jtOrderMapper.select(orderId);
		return jtOrder;
	}

}
