package org.mybatis.config;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class XmlConfigParser {
    public  static Configuration configuration=new Configuration();

    public  static  void  parser(InputStream inputStream) throws  Throwable{
//解析mybatis-config.xml
        //创建saxReader
        SAXReader saxReader=new SAXReader();
        //读取xml文件
        Document document=saxReader.read(inputStream);
        //找到property标签
        List<Element> propertyElements=document.selectNodes("//property");
        //遍历4个property标签
        for(Element element:propertyElements){
            //name属性的值
            String valueOfName=element.attributeValue("name");
            //value属性的值
            String valueOfValue=element.attributeValue("value");
            switch (valueOfName){
                case "driver":
                    configuration.setDriver(valueOfValue);
                    break;
                case "url":
                    configuration.setUrl(valueOfValue);
                    break;
                case "username":
                    configuration.setUsername(valueOfValue);
                    break;
                case "password":
                    configuration.setPassword(valueOfValue);
                    break;
            }
        }
        //找到所有mapper标签
        HashMap<String,SqlMapper> sqlMappers=new HashMap<>();
        configuration.setSqlMappers(sqlMappers);

        List<Element> mapperElements=document.selectNodes("//mapper");
        for (Element element:mapperElements){
            String mapperFileName=element.attributeValue("resource");
            parseMapper(mapperFileName);
        }
        System.out.println(configuration);

    }

    private static void parseMapper(String mapperFileName) throws Throwable {
        //得到类加载器
        ClassLoader classLoader=XmlConfigParser.class.getClassLoader();
        //得到inputstream
        InputStream inputStream=classLoader.getResourceAsStream(mapperFileName);
        //创建saxReader
        SAXReader saxReader=new SAXReader();
        //读xml
        Document document=saxReader.read(inputStream);
        //读select
        List<Element> selectElements=document.selectNodes("//select");
        for (Element element:selectElements){
        //得到id,rustType,sql
            String id=element.attributeValue("id");
            String resultType=element.attributeValue("resultType");
            String sql=element.getText();
       // 创建sqlMapper
            SqlMapper sqlMapper=new SqlMapper();
            sqlMapper.setId(id);
            sqlMapper.setResultType(resultType);
            sqlMapper.setSql(sql);
        //把id,sqlMapper放到configuration.sqlMappers
            configuration.getSqlMappers().put(id,sqlMapper);
            }
    }
}
