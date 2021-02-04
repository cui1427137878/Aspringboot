package com.tedu.project_jt.controller;

import com.tedu.project_jt.mapper.AdminMapper;
import com.tedu.project_jt.pojo.Admin;
import com.tedu.project_jt.pojo.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//处理后台管理中的管理员相关的请求
@RestController
public class AdminController {
    @Autowired
    AdminMapper adminMapper;
    //管理员登录
    @RequestMapping("/admin/login")
    @CrossOrigin//允许任何网站通过javascript访问
    public Admin login(Admin admin)
    {
        //where adminName='root' and adminPassword='root'
        AdminExample adminExample=new AdminExample();
        AdminExample.Criteria criteria=adminExample.or();
        criteria.andAdminNameEqualTo(admin.getAdminName());
        criteria.andAdminPasswordEqualTo(admin.getAdminPassword());
        List<Admin> adminList=adminMapper.selectByExample(adminExample);
        if (adminList!=null && adminList.size()>=1)
        {
            Admin returnAdmin=adminList.get(0);//取集合的第一个数据
            //密码不能返回给浏览器
            returnAdmin.setAdminPassword("");
            return  returnAdmin;
        }
        //sqlyog查看admin表
        //重启服务器 localhost:1314/admin/login?adminName=root&adminPassword=root
        return  null;
    }
}
