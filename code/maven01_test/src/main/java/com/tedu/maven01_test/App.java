package com.tedu.maven01_test;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
try {
	//创建实体类
	ItemCategory itemCategory=new ItemCategory();
	itemCategory.setId(88);
	itemCategory.setName("手机");
	//创建一个把实体类转成json的对象 讲义4.3.5.2 拷贝dependency标签
	ObjectMapper objectMapper=new ObjectMapper();
	//转换
	String json=objectMapper.writeValueAsString(itemCategory);
	//打印json
	System.out.println(json);
} catch (Exception e) {
	e.printStackTrace();
	//发邮件
	//发短信
}
    }
}
