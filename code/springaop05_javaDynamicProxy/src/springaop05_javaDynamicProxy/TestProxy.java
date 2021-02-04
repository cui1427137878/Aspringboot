package springaop05_javaDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {

	public static void main(String[] args) {
		UserDAO target=new UserDAO();//����Ŀ��
		Object proxyObject=getProxy(target);
		
		//���Դ�����������
		Class proxyObjectClazz=proxyObject.getClass();//�õ��������������
		//com.sun.Proxy.$Proxy0
		System.out.println(proxyObjectClazz.getName());
				//���Դ������ķ���
		Method[] methods=proxyObjectClazz.getDeclaredMethods();
		for (Method method:methods) {
			System.out.println(method.getName());
		}
		
		//ͨ���������ȥ����Ŀ�����ķ���
		//$proxy0 implements IDAO ;proxyObject����ת��UserDAO
		Object result=((IDAO)proxyObject).select("admin");
		System.out.println("result="+result);

	}
	//�����������
	private static Object getProxy(IDAO target) {
		//�ŵ���Ŀ��������нӿڵ������
		Class[] interfaces=target.getClass().getInterfaces();
		//�������
		ClassLoader classLoader=target.getClass().getClassLoader();
		//java���ɴ�����$proxy0{select(){���ýӿ�InvocatoinHandler.invoke}}
		MyHandler myHandler=new MyHandler(target);
		Object proxyObject=Proxy.newProxyInstance
				(classLoader, interfaces, myHandler);
		return proxyObject;
	}
	//��̬�ڲ���
	static class MyHandler implements InvocationHandler{

		IDAO target;//Ŀ����Ķ���
		
		public MyHandler(IDAO target) {
			super();
			this.target = target;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("invoke() ������="+method.getName());
			System.out.println("invoke�е�ʱ��");
			//����Ŀ�����ķ���
			Object result=method.invoke(target, args);
			return result;
		}
		
	}

}
