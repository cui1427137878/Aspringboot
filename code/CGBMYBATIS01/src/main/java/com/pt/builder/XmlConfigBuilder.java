package com.pt.builder;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 1)读取配置文件
 * 2)解析配置文件
 * 3)对内容进行封装
 *
 */
public class XmlConfigBuilder {
	InputStream in;
	public XmlConfigBuilder(String file)throws Exception {
		//1.读取文件
		in=getClass().getClassLoader().getResourceAsStream(file);
	}
	
	/**基于dom技术解析xml(标准)
	 * xml常用解析方案：dom,dom4j,sax,pull,...
	 * @return
	 * @throws Exception
	 */
	public Config parse() throws Exception{
		//1.获取解析器对象
		DocumentBuilderFactory factory=
		DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		//2.解析流对象获取document对象
		Document doc=builder.parse(in);
		//3.处理Document对其内容进行封装
		return processDocument(doc);
	}
	private Config processDocument(Document doc) {
		NodeList list=doc.getElementsByTagName("setting");
		Config config=new Config();
		for(int i=0;i<list.getLength();i++) {
			Node node=list.item(i);
			NamedNodeMap attrMap= node.getAttributes();
			String key=attrMap.getNamedItem("name").getNodeValue();
			String value=attrMap.getNamedItem("value").getNodeValue();
			config.putSetting(key, value);
		}
		return config;
	}
	public static void main(String[] args)throws Exception {
		XmlConfigBuilder builder=new XmlConfigBuilder("com/pt/builder/configs.xml");
		Config config=builder.parse();
		System.out.println(config);
	}
}







