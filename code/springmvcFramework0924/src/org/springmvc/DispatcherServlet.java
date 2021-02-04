package org.springmvc;
//���������յ�webServer������ ����controller

import java.lang.reflect.Method;

import javax.http.HttpServletRequest;
import javax.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DispatcherServlet {
	
	WebApplicationContext webApplicationContext=new WebApplicationContext();
	
	public DispatcherServlet() throws Throwable{
		//����webApplicationContext.init
		webApplicationContext.init();
	}
	
	//�յ�webServer������ ����controller
	/**
	 * 
	 * @param request �ŵ�����
	 * @return controllerִ�еĽ��
	 */
	public HttpServletResponse doDispatch(HttpServletRequest request) 
			throws Throwable{
		
		//1,��request�еõ�url
		String url=request.getUrl();
		//2,����url��webApplicationContext.urlMapping�еõ�controllerDefinition
		ControllerDefinition definition=webApplicationContext
				.urlMapping.get(url);
		//3,��diefinition�еõ�controllerName
		String controllerName=definition.getControllerName();
		//4,��difinition�еõ�������
		String methodName=definition.getMethodName();
		//5,ͨ�����䴴������
		Class clazz=Class.forName(controllerName);
		Object object=clazz.newInstance();
		//6,ͨ������󴴽�method
		Method method=clazz.getDeclaredMethod(methodName);
		//7,ͨ��method.invokeִ�з���
		Object result=null;
				boolean isJson=definition.isJson;
				if (isJson==false) {
					//register(),login()���صľ���HttpServletResponse
				result=method.invoke(object);
				}else {
					//OrderController.select()���ص���Order
					Object object2=method.invoke(object);//Order
					//��orderת��json�ַ���
					ObjectMapper objectMapper=new ObjectMapper();
					String json=objectMapper.writeValueAsString(object2);
					//��json�ַ����ŵ�HttpServletResponse��
					HttpServletResponse response=new HttpServletResponse();
					response.setResponseBody(json);
					result=response;
					
				}
		HttpServletResponse response=(HttpServletResponse) result;
		return response;
		
	}

}
