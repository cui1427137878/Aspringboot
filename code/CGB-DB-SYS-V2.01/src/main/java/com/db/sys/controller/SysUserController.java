package com.db.sys.controller;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.db.common.vo.JsonResult;
import com.db.common.vo.PageObject;
import com.db.sys.entity.SysUser;
import com.db.sys.service.SysUserService;
import com.db.sys.vo.SysUserDeptVo;

@Controller
@RequestMapping("/user/")
public class SysUserController {
	   @Autowired
	   private SysUserService sysUserService;
	   
	   @GetMapping("doUserListUI")
	   public String doUserListUI(){
		   return "sys/user_list";
	   }
	   
	   @GetMapping("doUserEditUI")
	   public String doUserEditUI(){
		   return "sys/user_edit";
	   }
	   
	   
	   @GetMapping("doFindObjectById")
	   @ResponseBody
	   public JsonResult doFindObjectById(Integer id){
		   return new JsonResult(
		   sysUserService.findObjectById(id));
	   }
	   
	   @PostMapping("doUpdateObject")
	   @ResponseBody
	   public JsonResult doUpdateObject(SysUser entity,
			   Integer[] roleIds){
		   sysUserService.updateObject(entity, roleIds);
		   return new JsonResult("update ok");
	   }
	   
	   @PostMapping("doSaveObject")
	   @ResponseBody
	   public JsonResult doSaveObject(SysUser entity,
			   Integer[] roleIds){
		   sysUserService.saveObject(entity, roleIds);
		   return new JsonResult("save ok");
	   }
	   
	   @PostMapping("doValidById")
	   @ResponseBody
	   public JsonResult doValidById(
			   Integer id,Integer valid){
		   //此登录用户是在认证时传入的一个身份，
		   //可以看ShiroUserRealm中的AuthenticationInfo方法
		   SysUser user=(SysUser)
		   SecurityUtils.getSubject()
		   .getPrincipal();
		   sysUserService.validById(id,valid,user.getUsername());
		   return new JsonResult("update ok");
	   }
	   
	   @RequestMapping("doFindPageObjects")
	   @ResponseBody
	   public JsonResult doFindPageObjects(
			   String username,Integer pageCurrent){
		   PageObject<SysUserDeptVo> pageObject=
		   sysUserService.findPageObjects(username,
				   pageCurrent);
	       return new JsonResult(pageObject);
	   }
}







