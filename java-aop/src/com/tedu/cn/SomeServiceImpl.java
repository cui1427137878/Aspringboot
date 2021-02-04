package com.tedu.cn;

import util.ServiceTools;

import java.util.Date;

/**
 * ClassName:com.tedu.cn.SomeServiceImpl
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Data:2020/10/24 16:07
 * Author:崔建新
 */
public class SomeServiceImpl implements Service {
    @Override
    public void doSome() {
        //动态添加代码
       /* ServiceTools.doTime();*/
        System.out.println("执行业务方法dosome");
       /* ServiceTools.doC();*/
    }

    @Override
    public void doOther() {
      /* ServiceTools.doTime();*/
        System.out.println("执行业务方法doother");
       /*ServiceTools.doC();*/
    }
}
