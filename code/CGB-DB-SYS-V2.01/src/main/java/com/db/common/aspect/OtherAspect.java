package com.db.common.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
/**
 * demo应用
 * @author ta
 */
@Order(2)
@Aspect
@Service
public class OtherAspect {
	/**
	 * 切入点：切入扩展功能的一些连接点(JoinPoint)的集合
	 */
    @Pointcut("bean(sysLogService)")
	public void doPointCut(){}
    
    /**前置通知:核心业务执行之前*/
    @Before("doPointCut()")
    public void beforeMethod(JoinPoint jp){
    	System.out.println("@Before");
    }
    /**后置通知：又称finally通知*/
    @After("doPointCut()")
    public void afterMethod(){
    	System.out.println("@After");
    }
    @AfterReturning("doPointCut()")
    public void returnMethod(){
    	System.out.println("@AfterReturning");
    }
    @AfterThrowing("doPointCut()")
    public void throwMethod(){
    	System.out.println("@AfterThrowing");
    }
    
    @Around("doPointCut()")
    public Object arroundMethod(ProceedingJoinPoint jp)
    throws Throwable{
    	try{
    	System.out.println("@Around before");
    	Object result=jp.proceed();
    	System.out.println("@Around AfterReturning");//AfterReturning
    	return result;
    	}catch(Exception e){
    	System.out.println("@Around afterthrowing");	
    	throw e;
    	}finally{
    	System.out.println("@Around after");//after
    	}
    }
}








