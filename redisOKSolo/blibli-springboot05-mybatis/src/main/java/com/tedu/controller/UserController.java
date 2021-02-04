package com.tedu.controller;

import com.tedu.mapper.UserMapper;
import com.tedu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;
    String msg;

    //查询全部
    @RequestMapping("/queryUserList")
    public List<User> queryUserList() {
        List<User> users = userMapper.queryUserList();
        return users;
    }

    ;

    @RequestMapping("/queryUserById")
    public User queryUserById(int id) {
        User user = userMapper.queryUserById(id);
        return user;
    }

    ;

    @RequestMapping("/addUser")
    public String addUser(User user) {
        if (userMapper.addUser(user) > 0) {
            msg = "插入成功";
        } else {
            msg = "失败";
        }
        return msg;
    }
    @RequestMapping("updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(3,"张99","111"));
        return "更新成功";
    }
    @RequestMapping("/delete")
    public String delete(int id){
        userMapper.delete(id);
        return "ok";
    }

}
