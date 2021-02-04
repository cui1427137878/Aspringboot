package com.tedu.cn.springbootjsp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName:IndexController
 * Package:com.tedu.cn.springbootjsp.web
 * Description:
 *
 * @Data:2020/11/7 14:11
 * Author:崔建新
 */
@Controller
public class IndexController {
    @RequestMapping("/say")
    public ModelAndView say(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("message","hello spring");
        mv.setViewName("say");
        return mv;
    }
}
