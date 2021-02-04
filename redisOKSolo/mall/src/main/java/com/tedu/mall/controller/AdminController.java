package com.tedu.mall.controller;

import com.tedu.mall.mapper.AdminMapper;
import com.tedu.mall.pojo.Admin;
import com.tedu.mall.pojo.AdminExample;
import com.tedu.mall.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminMapper adminMapper;

    //管理员登录
    public Result login(Admin admin) {
        Result result = null;
        //1,数据验证
        if (StringUtils.isEmpty(admin.getAdminName())) {
            result = new Result(1, "用户名不合法");
            return result;
        }
        if (StringUtils.isEmpty(admin.getAdminPassword())) {
            result = new Result(2, "密码不合法");
            return result;
        }
        //where username='' and passoword=''
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.or();
        criteria.andAdminNameEqualTo(admin.getAdminName());
        criteria.andAdminPasswordEqualTo(admin.getAdminPassword());
        List<Admin> list = adminMapper.selectByExample(example);
        if (list.size() >= 1) {
            Admin dbAdmin = list.get(0);
            dbAdmin.setAdminPassword("");
            result = new Result(0, "登录成功", dbAdmin);
        } else {
            result = new Result(3, "登录失败");
        }
        return result;
    }
}
