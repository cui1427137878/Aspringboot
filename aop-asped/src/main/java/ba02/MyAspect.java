package ba02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;


//aspect框架中的注解，表示切面类，给目标类增加功能的
@Component("myAspect")
@Aspect
public class MyAspect {
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther(..))" ,returning = "res")
    public void myAfterReturning(Object res){
        System.out.println("后置通知,在执行目标方法之后，获取的返回值是"+res);
    }
    @AfterReturning(value = "execution(* *..SomeServiceImpl.doOther2(..))" ,returning = "res")
    public void myAfterReturning2(Object res){
        System.out.println("后置通知,在执行目标方法之后，获取的返回值是"+res);
    }

}

