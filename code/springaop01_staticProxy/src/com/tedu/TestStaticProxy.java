package com.tedu;

//���Ծ�̬����������
public class TestStaticProxy {

	public static void main(String[] args) {

		//����Ŀ�������
		UserDAO userDAO=new UserDAO();
		OrderDAO orderDAO=new OrderDAO();
		//��������
		Proxy userDAOProxy=new Proxy(userDAO);
		Proxy orderDAOProxy=new Proxy(orderDAO);
		//���ô���ķ���
		userDAOProxy.select();
		orderDAOProxy.select();
		//ֱ�ӵ���Ŀ����
		userDAO.select();
		orderDAO.select();
	}

}
