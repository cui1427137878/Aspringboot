package org.springmvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.http.HttpServletRequest;
import javax.http.HttpServletResponse;
import java.lang.reflect.Method;

public class DispatcherServlet {
    WebApplicationContext webApplicationContext = new WebApplicationContext();

    public DispatcherServlet() throws Throwable {
        webApplicationContext.init();
    }

    public HttpServletResponse doDispatch(
            HttpServletRequest request
    ) throws Throwable {
        //从request中得到url
        String url=request.getUrl();
        //根据url从webApplicationContext.urlMapping中得到ControllerDifition
        ControllerDefinition definition=webApplicationContext.urlMapping.get(url);
        //得controllername
        String controllerName=definition.getControllerName();
        //得方法名
        String methodName=definition.getMethodName();
        //得到到类对象
        Class clazz=Class.forName(controllerName);
        //创建类的对象
        Object controllerObject=clazz.newInstance();
        //得到method对象
        Method method=clazz.getDeclaredMethod(methodName);
        //通过method.invoke执行方法
       HttpServletResponse response= null;
               Object result=method.invoke(controllerObject);
       //isJson=true,方法返回的是对象
        if (definition.isJson){
            //把对象转成json
            ObjectMapper objectMapper=new ObjectMapper();
            String string=objectMapper.writeValueAsString(result);
            //再把json放到response中
             response=new HttpServletResponse();
             response.setResponseBody(string);
        }else {
            response= (HttpServletResponse) result;
        }
        //返回controller执行的结果给webServer

        return response;
    }
}
