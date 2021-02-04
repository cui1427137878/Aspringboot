package com.tedu.spingbootspringmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:IndexController
 * Package:com.tedu.spingbootspringmvc.web
 * Description:
 *
 * @Data:2020/11/5 20:10
 * Author:崔建新
 */
@Controller
public class IndexController {
    @RequestMapping(value="/springboot")
    public @ResponseBody
    String say(){

        return "hello,spring";
    }
}
