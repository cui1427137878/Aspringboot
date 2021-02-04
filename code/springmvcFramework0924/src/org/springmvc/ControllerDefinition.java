package org.springmvc;

//实体类
public class ControllerDefinition {
	String url;// /login,/register
	String controllerName;//UserController
	String methodName;// login(),register()
	boolean isJson;//true 返回的是json
	public ControllerDefinition(String url, String controllerName, String methodName, boolean isJson) {
		super();
		this.url = url;
		this.controllerName = controllerName;
		this.methodName = methodName;
		this.isJson = isJson;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getControllerName() {
		return controllerName;
	}
	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public boolean isJson() {
		return isJson;
	}
	public void setJson(boolean isJson) {
		this.isJson = isJson;
	}
	

}
