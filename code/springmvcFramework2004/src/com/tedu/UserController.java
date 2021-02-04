package com.tedu;

import org.springmvc.Controller;
import org.springmvc.RequestMapping;

import javax.http.HttpServletResponse;

@Controller
public class UserController {
    @RequestMapping("/login")
    public HttpServletResponse login()
    {
        HttpServletResponse response=new HttpServletResponse();
        response.setResponseBody("login success");
        return response;
    }

    @RequestMapping("/register")
    public HttpServletResponse register(){
        HttpServletResponse response=new HttpServletResponse();
        response.setResponseBody("register success");
        return  response;
    }
}
