package com.tedu.controller;

import com.tedu.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(description = "管理员工")
@RestController
public class HelloController {

    @ApiOperation("user测试类")//给类注解
    @GetMapping("/hello")
    public User hello(User user){
    return user;
    }

    @ApiOperation("user测试类")//给类注解
    @PostMapping("/hello")
    //加@Requestbody,实体类在swagger中直接有
    public User hello1(@RequestBody User user){
        return user;
    }

}
