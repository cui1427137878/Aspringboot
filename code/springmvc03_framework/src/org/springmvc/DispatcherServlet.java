package org.springmvc;

import java.lang.reflect.Method;

import javax.http.HttpServletRequest;
import javax.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DispatcherServlet {
	WebApplictionContext context = new WebApplictionContext();

	public DispatcherServlet() throws Throwable {
		context.init();
	}

	public HttpServletResponse doDispatch(HttpServletRequest request) throws Throwable {
		// 到webApplicationContext.urlMapping找到controller
		ControllerDefinition controllerDefinition = context.UrlMapping.get(request.getUrl());
		// 调用controller中的方法
		String controllerName = controllerDefinition.getControllerName();
		String methodName = controllerDefinition.getMethodName();

		Class clazz = Class.forName(controllerName);
		Object controllerObject = clazz.newInstance();
		Method method = clazz.getDeclaredMethod(methodName);
		// OrderController.getOrder()返回的是OrderEntity
		// UserController.register()/login()返回的是response
		HttpServletResponse response = null;
		if (controllerDefinition.isJson == false) {
			// userController
			response = (HttpServletResponse) method.invoke(controllerObject);
		} else {
			// orderController
			Object result = method.invoke(controllerObject);

			// 用jackson框架把result转成json字符串
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString = objectMapper.writeValueAsString(result);
			response = new HttpServletResponse();
			response.setResponseBody(jsonString);
		}
		return response;
	}
}
