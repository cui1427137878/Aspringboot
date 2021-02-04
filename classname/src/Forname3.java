import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * ClassName:Forname3
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Data:2020/10/27 9:30
 * Author:崔建新
 */
public class Forname3 {
    //读取classinfo.properties文件
    public String test1() throws Exception {
        FileReader reader=new FileReader("classinfo.properties");
        Properties pro=new Properties();
        pro.load(reader);
        pro.clone();
        reader.close();
        String classname=pro.getProperty("className");
        return classname;
    }
}
