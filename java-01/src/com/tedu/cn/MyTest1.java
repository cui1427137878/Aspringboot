package com.tedu.cn;

/**
 * ClassName:MyTest1
 * Package:com.tedu.cn
 * Description:
 *
 * @Data:2020/10/19 19:37
 * Author:崔建新
 */
public class  MyTest1 {
    public static void main(String[] args) {
        int num=3;
        for (int i=3; i<10; i++) {
            System.out.println("我是derder的大哥,第"+(i-2)+"次发！应该发"+num+"个感叹号");
            num+=i;
        }
    }
}
