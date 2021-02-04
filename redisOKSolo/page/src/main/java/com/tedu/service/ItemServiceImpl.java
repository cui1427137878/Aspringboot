package com.tedu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tedu.mapper.ItemPageMapper;
import com.tedu.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemPageMapper itemPageMapper;
    public  List<Item> selectPage(){
        PageHelper.startPage(2,2);//这句控制每页显示两个，紧跟他下面查询所有的语句
        List<Item> itemList=itemPageMapper.selectPage();
        PageInfo pageInfo=new PageInfo(itemList);
        return itemList;
    }
    public  PageInfo selectPage1(){
        //(1,2)这句控制每页显示两个，紧跟他下面查询所有的语句
        PageHelper.startPage(0,2);
        List<Item> itemList=itemPageMapper.selectPage();
        //(2,3)PageInfo,将查询的总数的查询传进去
        PageInfo pageInfo=new PageInfo(itemList);

        return pageInfo;
    }
}
