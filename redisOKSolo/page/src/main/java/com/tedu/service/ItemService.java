package com.tedu.service;

import com.github.pagehelper.PageInfo;
import com.tedu.pojo.Item;

import java.util.List;

public interface ItemService {
    public List<Item> selectPage();
    public  PageInfo selectPage1();
}
