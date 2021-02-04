package org.springmvc;

import java.lang.reflect.Method;
import java.util.HashMap;

public class WebApplicationContext {
    public   HashMap<String,ControllerDefinition> urlMapping=new HashMap<>();
    //   /login:controllerDefinition[UserController,login,false]
    //   /register:controllerDefinition[UserController,register,false]
    public void init() throws  Throwable{
//扫描所有的contorller
        String[] controllerNames={"com.tedu.UserController"
        ,"com.tedu.OrderController"};
        //遍历所有的controller
        for (String controllerName:controllerNames) {
            Class clazz=Class.forName(controllerName);
            //得到controller的所有方法
            Method[] methods=clazz.getDeclaredMethods();
            //遍历每个方法
            for (Method method:methods) {
                //判断方法有没有加@requestMapping
                RequestMapping requestMapping=method.getAnnotation(RequestMapping.class);
                if (requestMapping!=null) {
                    //得到url
                    String url=requestMapping.value();
                    //创建controllerDefinition
                    String methodName=method.getName();
                    boolean isJson=false;
                    //判断类有没有加@RestController,如果加了，isJson=true
                    RestController restController= (RestController)
                            clazz.getAnnotation(RestController.class);
                    if (restController!=null){
                        isJson=true;
                    }
                    ControllerDefinition definition=new ControllerDefinition
                            (controllerName,methodName,isJson);
                    //把controllerDefinition放到urlMapping中
                    urlMapping.put(url,definition);
                }
            }
        }
    }
}
