package com.tedu.service;

import com.tedu.pojo.Item;

import java.util.List;

public interface ItemService {
    public List<Item> getItem(Integer orderId);
}
