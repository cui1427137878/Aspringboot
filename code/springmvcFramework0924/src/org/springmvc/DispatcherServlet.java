package org.springmvc;
//控制器，收到webServer的请求 ，调controller

import java.lang.reflect.Method;

import javax.http.HttpServletRequest;
import javax.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DispatcherServlet {
	
	WebApplicationContext webApplicationContext=new WebApplicationContext();
	
	public DispatcherServlet() throws Throwable{
		//调用webApplicationContext.init
		webApplicationContext.init();
	}
	
	//收到webServer的请求 ，调controller
	/**
	 * 
	 * @param request 放的请求
	 * @return controller执行的结果
	 */
	public HttpServletResponse doDispatch(HttpServletRequest request) 
			throws Throwable{
		
		//1,从request中得到url
		String url=request.getUrl();
		//2,根据url从webApplicationContext.urlMapping中得到controllerDefinition
		ControllerDefinition definition=webApplicationContext
				.urlMapping.get(url);
		//3,从diefinition中得到controllerName
		String controllerName=definition.getControllerName();
		//4,从difinition中得到方法名
		String methodName=definition.getMethodName();
		//5,通过反射创建对象
		Class clazz=Class.forName(controllerName);
		Object object=clazz.newInstance();
		//6,通过类对象创建method
		Method method=clazz.getDeclaredMethod(methodName);
		//7,通过method.invoke执行方法
		Object result=null;
				boolean isJson=definition.isJson;
				if (isJson==false) {
					//register(),login()返回的就是HttpServletResponse
				result=method.invoke(object);
				}else {
					//OrderController.select()返回的是Order
					Object object2=method.invoke(object);//Order
					//把order转成json字符串
					ObjectMapper objectMapper=new ObjectMapper();
					String json=objectMapper.writeValueAsString(object2);
					//把json字符串放到HttpServletResponse中
					HttpServletResponse response=new HttpServletResponse();
					response.setResponseBody(json);
					result=response;
					
				}
		HttpServletResponse response=(HttpServletResponse) result;
		return response;
		
	}

}
