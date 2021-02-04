package com.tedu.sp02itemservice.controller;

import com.tedu.pojo.Item;
import com.tedu.pojo.JsonResult;
import com.tedu.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping("/{orderId}")
    public JsonResult getItem(@PathVariable  Integer orderId){
        List<Item> itemList=itemService.getItem(orderId);
        JsonResult jsonResult=new JsonResult(0,"ok",itemList);
        return jsonResult;
    }
}
