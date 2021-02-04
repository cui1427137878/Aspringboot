package com.pd.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.pd.common.utils.FileUtil;


@Controller
@RequestMapping("/api")
public class ApiController {
	
	@RequestMapping("/getIndexItem")
	@ResponseBody
	public String getIndexItem(HttpServletResponse response) throws Exception
	{
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-credentials", "true");
		String jsonString=FileUtil.readFile("index.json");
		return jsonString;
		
	}
	
	//   http://172.211.100.32/api/getItemDetail
	//     .html?itemId=10000028
	@RequestMapping("/getItemDetail")
	@ResponseBody
	public String getItemDetail(HttpServletResponse response,Long itemId) 
			throws Exception
	{
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-credentials", "true");
		String jsonString=FileUtil.readFile(itemId+".json");
		return jsonString;
	}
	
	
}
