import java.util.ArrayList;
import java.util.List;

public class Main {

    //字典
    public static ArrayList<String> dic=
            new ArrayList<>();
    public static void main(String[] args) {
//向字典添加关键词
        dic.add("java");
        dic.add("编程");
        dic.add("语言");
        dic.add("北京天安门");
        String text="java是编程语言";
        List<String> result=segment(text);
        System.out.println(result);
    }
    //分词
    public static List<String> segment(String text)
    {
        //放分词结果
        ArrayList<String> result=new ArrayList<>();
        //while()分多次取出候选词
        while(text.length()>0){
            //字典中关键词最大长度是5
            int max_length=5;
            int len=max_length;
            if (text.length()<max_length)
            {
                len=text.length();
            }
            String tryWord=text.substring(0,len);
            //1,判断候选词在不在字典中
            while(!dic.contains(tryWord)){
                //2,判断是不是单字
                if (tryWord.length()==1)
                {
                    //是单字，退出while
                    break;
                }
                //3,从右边去掉一个字符
                tryWord=tryWord.substring
                        (0, tryWord.length()-1);
            }
            result.add(tryWord);
            //去掉最左边的关键词
            text=text.substring(tryWord.length());
        }
        return result;
    }

}