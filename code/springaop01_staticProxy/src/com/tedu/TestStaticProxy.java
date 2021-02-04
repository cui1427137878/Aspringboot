package com.tedu;

//测试静态代理的入口类
public class TestStaticProxy {

	public static void main(String[] args) {

		//创建目标类对象
		UserDAO userDAO=new UserDAO();
		OrderDAO orderDAO=new OrderDAO();
		//创建代理
		Proxy userDAOProxy=new Proxy(userDAO);
		Proxy orderDAOProxy=new Proxy(orderDAO);
		//调用代理的方法
		userDAOProxy.select();
		orderDAOProxy.select();
		//直接调用目标类
		userDAO.select();
		orderDAO.select();
	}

}
