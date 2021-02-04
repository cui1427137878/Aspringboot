package org.springmvc;
//实体类
public class ControllerDefinition {
    String controllerName;
    String methodName;
    boolean isJson;//true返回的是json,false返回的是字符串

    public ControllerDefinition(String controllerName, String methodName, boolean isJson) {
        this.controllerName = controllerName;
        this.methodName = methodName;
        this.isJson = isJson;
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

    public void setJson(boolean json) {
        isJson = json;
    }
}
