package org.springmvc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//���ע���������
@Retention(RetentionPolicy.RUNTIME)//������ʱ��Ч
public @interface RestController {

}
