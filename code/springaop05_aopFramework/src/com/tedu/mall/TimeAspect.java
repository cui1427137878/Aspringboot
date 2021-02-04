package com.tedu.mall;

import org.spring.aop.After;
import org.spring.aop.Aspect;
import org.spring.aop.Before;
import org.spring.aop.Pointcut;

@Aspect
public class TimeAspect {
	long startTime;
	@Pointcut("com.tedu.mall.UserServiceImpl.register")
	public void pointCut() {}
	
	@Before
	public void doBefore() {
		System.out.println("doBefore()");
		startTime=System.nanoTime();
	}
	
	@After
	public void doAfter() {
		System.out.println("doAfter()");
		System.out.println("time:"+(System.nanoTime()-startTime));

	}

}
