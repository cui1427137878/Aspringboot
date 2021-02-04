package com.tedu.mall.controller;

import com.tedu.mall.mapper.ItemMapper;
import com.tedu.mall.pojo.Category;
import com.tedu.mall.pojo.Item;
import com.tedu.mall.pojo.ItemExample;
import com.tedu.mall.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemMapper itemMapper;

    //删除商品
    @RequestMapping("/delete")
    public Result delete(Integer itemId) {
        //deleteByExample()
        int row = itemMapper.deleteByPrimaryKey(itemId);
        if (row >= 1) {
            return new Result(0, "ok");
        }
        return new Result(201, "删除失败");
    }

    //修改商品
    @RequestMapping("/update")
    //?itemId=1&itemName=mate20
    public Result update(Item item) {
        //数据验证
        int row = itemMapper.updateByPrimaryKey(item);
        if (row >= 1) {
            return new Result(0, "ok");
        }
        return new Result(201, "更新失败");
    }

    //添加商品
    @RequestMapping("/insert")
    //不要传itemId
    // /item/insert/?itemName=mate10&itemPrice=200
    public Result insert(Item item) {
        //数据验证
        if (StringUtils.isEmpty(item.getItemName())) {
            return new Result(101, "名称不合法");
        }
        if (StringUtils.isEmpty(item.getItemDesc())) {
            return new Result(102, "描述不合法");
        }
        int row = itemMapper.insertSelective(item);
        if (row >= 1) {
            return new Result(0, "ok");
        }
        return new Result(201, "添加失败");
    }

    //根据商品id查询商品
    @RequestMapping("/selectById")
    public Result selectById(Integer itemId) {
        //必须完成数据合法法验证
        //前端做了验证，controller还要做
        Item item = itemMapper.selectByPrimaryKey(itemId);
        return new Result(0, "查询成功", item);
    }

    @RequestMapping("/selectByCategoryId")
    public Result selectByCategoryId(Integer categoryId) {
        //where category_id=1
        ItemExample example = new ItemExample();
        ItemExample.Criteria criteria = example.or();
        criteria.andCategoryIdEqualTo(categoryId);
        List<Item> list = itemMapper.selectByExample(example);
        return new Result(0, "查询成功", list);
    }
}
