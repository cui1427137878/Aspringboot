package com.tedu.mall.controller;

import com.tedu.mall.mapper.CategoryMapper;
import com.tedu.mall.pojo.Category;
import com.tedu.mall.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;
    @RequestMapping("/cat/selectAll")
    public Result selectAll(){
        List<Category> list=categoryMapper.selectByExample(null);
        return new Result(0,"查询成功",list);
    }
}
