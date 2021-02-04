package com.tedu.sp03_sms.controller;

import java.util.HashMap;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;

@RestController
public class SMSController {
	@RequestMapping("/sendSMS")
	public String send() {
		//生产环境请求地址：app.cloopen.com
	    String serverIp = "app.cloopen.com";
	    //请求端口
	    String serverPort = "8883";
	    //共有7处地方需要修改
	    //修改1 ：管理-->控制台首页中能查到accountSId
	    String accountSId = "";
	  //修改2 ：管理-->控制台首页中能查到accountToken
	    String accountToken = "";
	    //修改3 ：管理-->应用管理-->应用列表-->应用01-->应用管理,查看appId
	    String appId = "";
	    CCPRestSmsSDK sdk = new CCPRestSmsSDK();
	    sdk.init(serverIp, serverPort);
	    sdk.setAccount(accountSId, accountToken);
	    sdk.setAppId(appId);
	    sdk.setBodyType(BodyType.Type_JSON);
	    //修改4 ：修改接收短信的手机号，手机号要在后台添加进去
	    String to = "132********";
	    //修改5 ：templateId改成1
	    String templateId= "1";
	    //修改6 ：
	    String[] datas = {"6688","3"};
	    String subAppend="1234";  //可选 扩展码，四位数字 0~9999
	    //修改7 ：修改reqId为新的
	    String reqId="fadfafas";  //可选 第三方自定义消息id，最大支持32位英文数字，同账号下同一自然天内不允许重复
	    //HashMap<String, Object> result = sdk.sendTemplateSMS(to,templateId,datas);
	    HashMap<String, Object> result = sdk.sendTemplateSMS(to,templateId,datas,subAppend,reqId);
	    if("000000".equals(result.get("statusCode"))){
	        //正常返回输出data包体信息（map）
	        HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
	        Set<String> keySet = data.keySet();
	        for(String key:keySet){
	            Object object = data.get(key);
	            System.out.println(key +" = "+object);
	        }
	    }else{
	        //异常返回输出错误码和错误信息
	        System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
	    }
		
		return "发送成功";
	}
}
