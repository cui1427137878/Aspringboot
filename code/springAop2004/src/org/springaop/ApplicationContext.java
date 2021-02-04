package org.springaop;

import com.TimeAspect;
import com.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class ApplicationContext {
    HashMap<String, Object> container = new HashMap<>();

    public ApplicationContext() throws Throwable {
        //1,创建UserServiceImpl,TimeAspect对象放到容器中
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        container.put("userServiceImpl", userServiceImpl);

        TimeAspect timeAspect = new TimeAspect();
        container.put("timeAspect", timeAspect);

        //2,遍历容器
        for (String key : container.keySet()) {
            //3,判断类有没有加Aspect
            Object object = container.get(key);
            Class clazz = object.getClass();
            Aspect aspect = (Aspect) clazz.getAnnotation(Aspect.class);
            if (aspect != null) {
                Object aspectObject = object;
                //4,遍历所有方法
                Method[] methods = clazz.getDeclaredMethods();
                String pointcutValue = null;
                Method beforeMethod = null, afterMethod = null;
                for (Method method : methods) {
                    Pointcut pointcut = method.getAnnotation(Pointcut.class);
                    Before before = method.getAnnotation(Before.class);
                    After after = method.getAnnotation(After.class);
                    //4.1 找到pointcut
                    if (pointcut != null) {
                        pointcutValue = pointcut.value();
                    }
                    //4.2 找到加了@before的方法
                    if (before != null) {
                        beforeMethod = method;
                    }
                    //4.3 找到加了@after的方法
                    if (after != null) {
                        afterMethod = method;
                    }
                }
                //4.4 从容器中取userServiceImpl的对象
                //pointcutValue=com.UserServiceImpl
                int begin = pointcutValue.lastIndexOf("." )+ 1;
                //UserServiceImpl
                String targetObjectKey = pointcutValue.substring(begin);
                //userServiceImpl
                targetObjectKey = Character.toLowerCase(targetObjectKey.charAt(0))
                        + targetObjectKey.substring(1);
                Object targetObject = container.get(targetObjectKey);
                //4.5 根据目标对象userServiceImpl创建代理对象
                ClassLoader classLoader=targetObject.getClass().getClassLoader();
                Class[] interfaces=targetObject.getClass().getInterfaces();
                AopHandler aopHandler=new AopHandler(targetObject,aspectObject,
                        beforeMethod,afterMethod);
                //new AopHandler(targetObject,aspectObject,beforeMethod,afterMethod)
                Object proxy= Proxy.newProxyInstance(classLoader,interfaces,aopHandler);
                //把代理对象放到容器中 userServiceImpl:proxy
                container.put(targetObjectKey,proxy);
            }
        }
    }
    public Object getBean(String key){
        return  container.get(key);
    }

    //内部类
    class AopHandler implements InvocationHandler {
        Object targetObject;
        Object aspectObject;
        Method beforeMethod;
        Method afterMethod;

        public AopHandler(Object targetObject, Object aspectObject, Method beforeMethod, Method afterMethod) {
            this.targetObject = targetObject;
            this.aspectObject = aspectObject;
            this.beforeMethod = beforeMethod;
            this.afterMethod = afterMethod;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //调用TimeAspect.before()
            if (beforeMethod!=null){
            beforeMethod.invoke(aspectObject);
            }
            //调用目标对象方法
           Object result= method.invoke(targetObject,args);
            //调用TimeAspect.after()
            if (afterMethod!=null){
                afterMethod.invoke(aspectObject);
            }

            return result;
        }
    }
}
