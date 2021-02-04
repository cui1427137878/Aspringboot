package org.springmvc;

//封装controller
public class ControllerDefinition {
	String url;// /register /login
	String controllerName;// UserController
	String methodName;// register,login
	Boolean isJson;
	public ControllerDefinition(String url, String controllerName, String methodName, Boolean isJson) {
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
	public Boolean getIsJson() {
		return isJson;
	}
	public void setIsJson(Boolean isJson) {
		this.isJson = isJson;
	}
	
}
