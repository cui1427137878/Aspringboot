package com.pt.builder;

import java.util.HashMap;
import java.util.Map;

public class Config {
     
	 //....
	 //基于此map封装配置文件中setting元素对应的配置信息
	 private Map<String,Object> settingMap=new HashMap<>();
	 public void putSetting(String key,Object value) {
		 settingMap.put(key, value);
	 }
	@Override
	public String toString() {
		return "Config [settingMap=" + settingMap + "]";
	}
	 
}
