package handler;

import util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ClassName:MyIncationHandler
 * Package:handler
 * Description:
 *
 * @Data:2020/10/26 9:35
 * Author:崔建新
 */
public class MyIncationHandler implements InvocationHandler {
    private Object target;

    public MyIncationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ServiceTools.doTime();
        Object res = method.invoke(target,args);
        ServiceTools.doC();
        return res;
    }
}
