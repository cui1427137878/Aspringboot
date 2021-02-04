package com.db.common.web;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.common.vo.JsonResult;
/**
 * 使用ControllerAdvice注解描述的类为一个全局异常
 * 处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public JsonResult doShiroException(
			ShiroException e){
		e.printStackTrace();
		JsonResult r=new JsonResult();
		r.setState(0);
		
		return r;
	}
    /**
     * @ExceptionHandler 是用于描述异常处理方法，
     * 此注解中定义的异常类型为方法可以处理的异常类型
     * (包含此类型的子类类型)
     * @param e
     * @return
     */
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleRuntimeException(
			RuntimeException e){
		e.printStackTrace();//给谁看?
		System.out.println("GlobalExceptionHandler.doHandleRuntimeException");
		return new JsonResult(e);
	}
}







