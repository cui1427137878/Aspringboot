package com.tedu.project_jt.controller;

import com.tedu.project_jt.mapper.ItemMapper;
import com.tedu.project_jt.pojo.Item;
import com.tedu.project_jt.pojo.ItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//处理商品相关的请求
@RestController
@RequestMapping("/item")//在类上面加url,每个方法不用加了，访问时还要加/item
public class ItemController {
    @Autowired
    ItemMapper itemMapper;
    //更新商品
    @RequestMapping("/update")
    //sqlyog 重新打开表
    //localhost:1314/item/update?itemId=2&itemName=华为手机&itemPrice=888
    //&itemDesc=aaaaa&itemImage=5.jpg&categoryId=2
    @CrossOrigin
    public  String update(Item item)
    {
        //根据主键更新商品
        int rowCount=itemMapper.updateByPrimaryKey(item);
        if (rowCount>=1){
            return  "更新成功";
        }else {
            return  "更新失败";
        }
    }
    //根据itemId删除商品
    @RequestMapping("/delete")
    //localhost:1314/item/delete?itemId=2
    @CrossOrigin
    public String delete(Integer itemId){
        //根据主键删除商品
        int rowCount=itemMapper.deleteByPrimaryKey(itemId);
        if (rowCount>=1)
        {
            return  "删除成功";
        }else {
            return "删除失败";
        }
    }

    //查询所有商品
    @RequestMapping("/selectAll")
    //localhost:1314/item/selectAll
    @CrossOrigin
    public  List<Item> selectAll()
    {
        return  itemMapper.selectByExample(null);
    }

    //添加商品
    @RequestMapping("/insert")
    //localhost:1314/item/insert?itemName=华为手机&categoryId=1&itemPrice=99
    //&itemDesc=华为最好的手机&itemImage=1.jpg
    @CrossOrigin
    public String insert(Item item)
    {
        int rowCount=itemMapper.insert(item);
        if (rowCount>=1){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }
    //根据分类的id查询商品
    @RequestMapping("/findByCategoryId")
    //进sqlyog 查看下那个分类下有商品
    //重启服务器  localhost:1314/item/findByCategoryId?categoryId=1
    @CrossOrigin
    public List<Item> findByCategoryId(Integer categoryId)
    {
        //select * from Item where category_id=1
        ItemExample itemExample=new ItemExample();
        ItemExample.Criteria criteria=itemExample.or();
        criteria.andCategoryIdEqualTo(categoryId);
        return  itemMapper.selectByExample(itemExample);
    }
    //根据商品id查询商品
    @RequestMapping("/findByItemId")
    //sqlyoug 查看商品，从表中找到一个itemid
    //localhost:1314/item/findByItemId?itemId=5
    @CrossOrigin
    public Item findByItemId(Integer itemId){
        //根据主键查询
        Item item=itemMapper.selectByPrimaryKey(itemId);
        return  item;
    }
}
