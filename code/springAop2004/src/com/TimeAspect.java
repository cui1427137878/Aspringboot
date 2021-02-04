package com;

import org.springaop.After;
import org.springaop.Aspect;
import org.springaop.Before;
import org.springaop.Pointcut;

@Aspect
public class TimeAspect {
    long startTime;

    @Pointcut("com.UserServiceImpl")
    public  void setPointCut(){

    }
    @Before
    public void getStartTime(){
        startTime=System.nanoTime();
        System.out.println("getStartTime()");
    }

    @After
    public void getEndTime()
    {
        long entTime=System.nanoTime();
        System.out.println("方法执行的时间="+(entTime-startTime));

    }
}
