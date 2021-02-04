package handler;

import util.Tool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
    private Object target;
    public  MyHandler(Object target){
        this.target=target;

    }
    //包公头,代理类，代理的方法，方法的参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(target, args);
        new Tool().tool();
        return invoke;
    }
}
