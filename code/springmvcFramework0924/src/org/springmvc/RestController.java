package org.springmvc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//方法返回的是对象
@Target(ElementType.TYPE)//加在类上
@Retention(RetentionPolicy.RUNTIME)//运行时有效
public @interface RestController {

}
