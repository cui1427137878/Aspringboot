package com.tedu.sp02itemservice.service;

import com.tedu.pojo.Item;
import com.tedu.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService
{
    @Override
    public List<Item> getItem(Integer orderId) {
        ArrayList<Item> itemList=new ArrayList<>();
        itemList.add(new Item(1,"mate10"));
        itemList.add(new Item(2,"mate20"));

        return itemList;
    }
}
