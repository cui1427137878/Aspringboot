package com.tedu.mall.controller;

import com.tedu.mall.mapper.UserMapper;
import com.tedu.mall.pojo.Result;
import com.tedu.mall.pojo.User;
import com.tedu.mall.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    //从容器中得到接口的代理对象
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/user/login")
    public Result login(User user){
        //where username='admin' and password='1'
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.or();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        List<User> userList=userMapper.selectByExample(example);
        Result result=null;
        if (userList.size()>=1){
            //登录成功了
            User dbUser=userList.get(0);
            //密码不能返回给前端
            dbUser.setPassword("");
            result=new Result(0,"登录成功",dbUser);
        }else {
            result=new Result(1,"登录失败");
        }
        return  result;
        //:8080/user/login?username=a&password=1
    }

    @RequestMapping("/user/register")
    public Result register(User user){
        //判断用户名是否存在
        //select * from user where username='admin'
        //example来生成where ,order by
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.or();
        criteria.andUsernameEqualTo(user.getUsername());
        List<User> userList=userMapper.selectByExample(example);
        Result result=null;
        if (userList.size()==0){
            //不存在
            int row=userMapper.insertSelective(user);
            if (row>=1){
                result=new Result(0,"注册成功");
            }else {
                result=new Result(1,"添加用户失败");
            }
        }else {
            result=new Result(2,"用户名已经存在");
        }
        return result;
        //关闭以前的进程，debug as
        //:8080/user/register?username=a&password=a
        //再刷新
    }


    @RequestMapping("/user/selectAll")
    @CrossOrigin
    public List<User> selectAll(){
        return  userMapper.selectByExample(null);
    }

}
