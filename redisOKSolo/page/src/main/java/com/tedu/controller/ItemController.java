package com.tedu.controller;

import com.github.pagehelper.PageInfo;
import com.tedu.mapper.ItemMapper;
import com.tedu.mapper.ItemPageMapper;
import com.tedu.pojo.Item;
import com.tedu.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping("/test")
    //查看分页
    public List<Item> test(){
        return itemService.selectPage();
    }
    @RequestMapping("/test1")
    //查看分页
    public PageInfo test1(){
        return itemService.selectPage1();
    }


}
