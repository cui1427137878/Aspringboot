package springaop02_reflect;

import java.lang.reflect.Method;

//获取目标类实现的接口的抽象方法
public class TestGetMethod {

	public static void main(String[] args) {
		//得到类对象
		UserDAO userDAO=new UserDAO();
		Class clazz=userDAO.getClass();
		//通过类对象得到接口中的方法
		Class[] interfaces=clazz.getInterfaces();//得到类的所有接口
		for (Class c:interfaces) {
			System.out.println(c.getName());
		    //得到某个接口的抽象方法
			Method[] methods=c.getDeclaredMethods();
			for (Method method:methods) {
				System.out.println("    "+method.getName());
			}
		}
		//显示方法名

	}

}
