package org.springmvc;
//��url,������������
public class ControllerDefinition {
	String url;//���ӣ�Ҳ��
	String className;
	String methodName;
	public ControllerDefinition(String url, String className, String methodName) {
		super();
		this.url = url;
		this.className = className;
		this.methodName = methodName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
}
