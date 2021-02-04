package org.spring.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Pointcut {
//切点com.tedu.mall.UserServiceImpl.register
	//调用register(),自动执行TimeAspect中的方法
	String value();
}
