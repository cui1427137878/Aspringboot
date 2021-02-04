package com.tedu;
//�����ࣺ��ʱ��󣬵���Ŀ����
//�������еķ��������Ŀ����ķ���һ�¡�
public class Proxy implements IDAO{

	//����Ŀ����
	IDAO target;
	//ͨ�����췽������һ��Ŀ�������
	public Proxy(IDAO target) {
		super();
		this.target = target;
	}
	@Override
	public void select() {
		//��ʱ�����չ���ܣ�������ʽ�Ĵ���ʵ�ֵ���չ����
		//����ʼʱ��
		long startTime=System.nanoTime();
		//����Ŀ����.select()
		target.select();
		//�ý���ʱ��
		long endTime=System.nanoTime();
		//��ӡʱ��
		System.out.println("time="+(endTime-startTime));
		
	}
	

}
