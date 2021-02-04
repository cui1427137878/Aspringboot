package com.tedu.cn.springbootcosfiguration.web;
import com.tedu.cn.springbootcosfiguration.config.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:Controller
 * Package:com.tedu.cn.springbootcosfiguration.web
 * Description:
 *
 * @Data:2020/11/7 11:21
 * Author:崔建新
 */
@Controller
public class IndexController {
@Autowired
    School school;
    @RequestMapping("/school")
    @ResponseBody
    public String hello(){
        return "schoolname="+school.getName()
                +"schoolsite"+school.getWebsite();
    }
}
