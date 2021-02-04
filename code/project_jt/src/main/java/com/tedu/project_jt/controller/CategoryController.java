package com.tedu.project_jt.controller;

import com.tedu.project_jt.mapper.CategoryMapper;
import com.tedu.project_jt.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//处理商品分类的请求
@RestController
public class CategoryController {
    //从spring容器中取个代理对象
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/category/selectAll")
    //关闭，重启服务器
    //localhost:1314/category/selectAll
    @CrossOrigin
    public List<Category> selectAll(){
        //不生成where 生成的是select * from category
        return  categoryMapper.selectByExample(null);
    }
}
