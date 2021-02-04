package com.tedu.mybatis02_multiTable.mapper;


import com.tedu.mybatis02_multiTable.pojo.JTOrder;
//通过接口操作数据库
//对象是由mybatis动态生成的代理对象
//在Application中加上@mapperscan告诉mybatis框架接口的包
public interface JTOrderMapper {
	//查询订单和用户信息
	public JTOrder select(Integer orderId);

}
