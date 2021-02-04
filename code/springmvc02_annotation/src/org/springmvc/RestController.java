package org.springmvc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//这个注解加在类上
@Retention(RetentionPolicy.RUNTIME)//在运行时有效
public @interface RestController {

}
