package org.springmvc;

import com.tedu.UserController;

//springmvc�������ʱִ��
public class Main {

	public static void main(String[] args) {
		//�ж�����û�м�RestController
		//.class������һ������ �����
		//new ArrayList ���鼯��
		//����� �������Ժͷ����� ����˽�����ԣ�ִ�з������ж���û�м�ע��
		Class clazz=UserController.class;
		//��������Զ���������
		RestController restController=(RestController) clazz
				.getAnnotation(RestController.class);
		if (restController!=null) {
			//����ע��
			UserController userController=new UserController();
			System.out.println(userController);
			//ɾ��UserController�ϵ�@restController
		}

	}

}
