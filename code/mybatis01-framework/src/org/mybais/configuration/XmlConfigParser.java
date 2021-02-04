package org.mybais.configuration;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

//解析mybatis-config.xml和mapper.xml
public class XmlConfigParser {
	public static Configuration configuration=new Configuration();

	public void parser(InputStream inputStream) throws Throwable{
		SAXReader saxReader=new SAXReader();
		Document document=saxReader.read(inputStream);
		List<Element> propertyElments=document.selectNodes("//property");
		for (Element element:propertyElments) {
			String valueOfName=element.attributeValue("name");
			String value=element.attributeValue("value");
			System.out.println(valueOfName+":"+value);
			switch (valueOfName) {
			case "driver":
				configuration.setDriver(value);
				break;
			case "url":
				configuration.setUrl(value);
				break;
			case "username":
				configuration.setUsername(value);
				break;
			case "password":
				configuration.setPassword(value);
				break;
			default:
				break;
			}
		}
		System.out.println(configuration);
		//解析所有的mapper.xml
		List<Element> mapperElements=document.selectNodes("//mapper");
		for (Element element:mapperElements) {
			String mapperFileName=element.attributeValue("resource");
			System.out.println("mapperFileName="+mapperFileName);
			parseMapper(mapperFileName);
		}
		System.out.println(configuration);
		
	}

	private void parseMapper(String mapperFileName) throws Throwable {
		ClassLoader classLoader=XmlConfigParser.class.getClassLoader();
		InputStream inputStream=classLoader.getResourceAsStream(mapperFileName);
		SAXReader saxReader=new SAXReader();
		Document document=saxReader.read(inputStream);
		HashMap<String, SqlMapper> sqlMappers=new HashMap<>();
		configuration.setSqlMappers(sqlMappers);
		List<Element> selectElements=document.selectNodes("//select");
		for (Element element:selectElements) {
			String id=element.attributeValue("id");
			String resultType=element.attributeValue("resultType");
			String sql=element.getText();
			SqlMapper sqlMapper=new SqlMapper(id, resultType, sql);
			sqlMappers.put(id, sqlMapper);
		}
		
	}
}
