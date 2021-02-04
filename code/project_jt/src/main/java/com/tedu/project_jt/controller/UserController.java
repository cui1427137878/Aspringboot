package com.tedu.project_jt.controller;

import com.tedu.project_jt.mapper.UserMapper;
import com.tedu.project_jt.pojo.User;
import com.tedu.project_jt.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//处理主站用户注册登录
@RestController
public class UserController {
    //从spring容器中获取UserMapper的代理对象
    @Autowired
    UserMapper userMapper;
    //完成登录
    @RequestMapping("/user/login")
    @CrossOrigin
    public User login(User user)
    {
        //where usename=admin and password=admin
        //使用UserExample.criteria生成where
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.or();
        //设置查询条件
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        //执行查询
        List<User> userList=userMapper.selectByExample(userExample);
        if (userList!=null && userList.size()>=1){
            //返回用户信息
            User returnUser=userList.get(0);
            //密码不能发给浏览器，把密码设置成null
            returnUser.setPassword("");
            return  returnUser;
        }
        return  null;
//关闭服务器，重启  debug窗口显示 port1314
        //localhost:1314/user/login?username=a&password=a
    }

    //完成注册
    @RequestMapping("/user/register")
    @CrossOrigin
    public String register(User user){
        //查询User表用户名是否存在
        // select * from user where username==admin
        //使用UserExample生成 where
        //UserExaple是逆向工程生成，在pojo包中
        UserExample userExample=new UserExample();
        //UserExample有个内部类Criteria
        UserExample.Criteria criteria=userExample.or();
        //设置查询条件
        criteria.andUsernameEqualTo(user.getUsername());
        //执行查询
      List<User> userList= userMapper.selectByExample(userExample);
      //判断集合中是否有数据
        if (userList!=null  && userList.size()==0){
            //用户名不存在,保存用户信息到user表中
          int rowCount= userMapper.insert(user);
          if (rowCount>=1){
              return "注册成功";
          }else {
              return "注册失败";
          }
        }else {
            return  "用户已存在";
        }

    }
}
