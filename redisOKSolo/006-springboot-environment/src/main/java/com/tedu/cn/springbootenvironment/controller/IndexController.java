package com.tedu.cn.springbootenvironment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:IndexController
 * Package:com.tedu.cn.springbootenvironment.controller
 * Description:
 *
 * @Data:2020/11/7 10:24
 * Author:崔建新
 */
@Controller
public class IndexController {
@Value("${aa}")
    private String aa;
    @RequestMapping("/say")
    @ResponseBody
    public String say(){
        return "hello"+aa;
    }
}
