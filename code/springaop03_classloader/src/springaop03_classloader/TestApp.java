package springaop03_classloader;

import java.io.IOException;
import java.io.InputStream;

public class TestApp {

	public static void main(String[] args) throws Throwable {
		//TestApp������������������ķ������ص�������
		//��������
		TestApp testApp=new TestApp();
		//�õ������
		Class clazz=testApp.getClass();//TestApp.classҲ����
		//���������õ���ļ�����
		ClassLoader classLoader=clazz.getClassLoader();
		System.out.println(classLoader);
		
		//��ȡ�ļ���java.io.File(d:\*\config.txt)
		
		//ͨ�����������ȡ�ļ����õ�������
		InputStream inputStream=classLoader
				.getResourceAsStream("config.txt");
		//�õ����ĳ���
		int length=inputStream.available();// main() throws Throwable
		//����byte[]
		byte[] data=new byte[length];
		//�������������ݶ���byte[]
		inputStream.read(data);
		//��byte[]ת���ַ���
		String proxyName=new String(data);
		System.out.println(proxyName);
		
		//ʹ���������������
		//�õ��������4�ַ�ʽ
		//1.����.class  2,object.getClass()  3,Class.forName()
		//4,�������.loadClass()
		Class proxyClazz=classLoader.loadClass(proxyName);
		Object proxyObject=proxyClazz.newInstance();
		System.out.println(proxyObject);

	}

}
