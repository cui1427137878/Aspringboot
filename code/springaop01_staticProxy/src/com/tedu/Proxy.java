package com.tedu;
//代理类：得时间后，调用目标类
//代理类中的方法必须和目标类的方法一致。
public class Proxy implements IDAO{

	//申明目标类
	IDAO target;
	//通过构造方法接收一个目标类对象
	public Proxy(IDAO target) {
		super();
		this.target = target;
	}
	@Override
	public void select() {
		//得时间叫扩展功能，无侵入式的代码实现的扩展功能
		//得起始时间
		long startTime=System.nanoTime();
		//调用目标类.select()
		target.select();
		//得结束时间
		long endTime=System.nanoTime();
		//打印时间
		System.out.println("time="+(endTime-startTime));
		
	}
	

}
