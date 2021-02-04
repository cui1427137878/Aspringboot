package ba01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/**
 * ClassName:MyAspect
 * Package:ba01
 * Description:
 *
 * @Data:2020/10/28 9:49
 * Author:崔建新
 */
//aspect框架中的注解，表示切面类，给目标类增加功能的
@Aspect
public class MyAspect {
    /*定义方法，实现切面功能的
    * 方法的定义要求
    * 1.是一个公共方法
    * 2.没有返回值
    * 3.方法名称自定义
    * 4.方法可以有参数，也可以没有
    * */



/*
    //doSome(..)表示不管几个参数,0个或多个参数
    @Before(value="execution(void ba01.SomeServiceImpl.doSome(..))")
    public void myBefore(){
        //切面执行的代码
        System.out.println("前置通知，切面功能，在目标方法之前执行之前"+new Date());
    }*/

   /* @Before(value="execution(void *..SomeServiceImpl.doSome(..))")
    public void myBefore(){
        //切面执行的代码
        System.out.println("前置通知，切面功能，在目标方法之前执行之前"+new Date());
    }*/

   @Before(value="execution(* *..SomeServiceImpl.doSome(..))")
   public void myBefore(JoinPoint jp){
       //切面执行的代码
       System.out.println("方法的签名"+jp.getSignature());
       System.out.println("方法的名称"+jp.getSignature().getName());
       Object[] args = jp.getArgs();
       for (Object arg:args){
           System.out.println("参数  "+arg);
       }
       System.out.println("前置通知，切面功能，在目标方法之前执行之前"+new Date());
   }
    @After(value ="execution(void ba01.SomeServiceImpl.doSome(..))" )
    public void myLast(){
        System.out.println("后置通知"+new Date());
    }
}
