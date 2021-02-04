package com.tedu.spingbootapplication1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:IndexController
 * Package:com.tedu.spingbootapplication1.controller
 * Description:
 *
 * @Data:2020/11/7 10:03
 * Author:崔建新
 */
@Controller
public class IndexController {
    @RequestMapping("/say")
    @ResponseBody
    public String say(){
        return "say hello";
    }
}
