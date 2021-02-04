package springaop02_reflect;

import java.lang.reflect.Method;

//��ȡĿ����ʵ�ֵĽӿڵĳ��󷽷�
public class TestGetMethod {

	public static void main(String[] args) {
		//�õ������
		UserDAO userDAO=new UserDAO();
		Class clazz=userDAO.getClass();
		//ͨ�������õ��ӿ��еķ���
		Class[] interfaces=clazz.getInterfaces();//�õ�������нӿ�
		for (Class c:interfaces) {
			System.out.println(c.getName());
		    //�õ�ĳ���ӿڵĳ��󷽷�
			Method[] methods=c.getDeclaredMethods();
			for (Method method:methods) {
				System.out.println("    "+method.getName());
			}
		}
		//��ʾ������

	}

}
