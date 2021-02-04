package com.tedu.springaop06_aop.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.ViewResolversBeanDefinitionParser;

//切面类:执行扩展功能，实现无侵入式编码
@Component // 组件，与@controller,@service功能一样，框架会自动创建对象
@Aspect // 这个类是个切面，在执行业务层方法之前或之后执行切面
public class TimeAspect {
	long startTime;// 业务层方法开始时间
    //切面像springmvc中的interceptor
    //.pathPattern(/order,/cart)
    //设置在运行那些业务层类那些方法时执行TimeAspect
    //pointcur:切入点，设置timeAspect执行的时机
	//execution:执行
	//第一个*代表的是类
	//第二个*代表的是类中的所有方法
	//(..)代表的是方法的参数可以是任何类型
	//public * 代表方法的返回类型是任何类型
	//注解中定义属性 value()
	//aop框架遍历方法找@PointCut注解，
	@Pointcut("execution(public * com.tedu.springaop06_aop.service.*.*(..))")
	public void aopPointCut() {
	}
	
	//得起始时间
	@Before("aopPointCut()")//在目标方法register之前执行
	public void getStartTime() {
		startTime=System.nanoTime();
	}
	//得结束时间
	@After("aopPointCut()")//在目标方法register之后执行
	public void getEndTime() {
		long endTime=System.nanoTime();
		System.out.println("业务层方法执行的时间:"+(endTime-startTime));
		//关闭服务器，重启 ,浏览器发请求，
		//localhost:1314/register?username=admin
		//console中查看日志
	}
}
