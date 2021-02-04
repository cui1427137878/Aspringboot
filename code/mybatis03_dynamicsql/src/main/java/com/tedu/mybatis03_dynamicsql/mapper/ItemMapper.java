package com.tedu.mybatis03_dynamicsql.mapper;

import java.util.List;

import com.tedu.mybatis03_dynamicsql.pojo.Item;

//操作Item表的
public interface ItemMapper {
	//返回的是多个数据
	public List<Item> select(Item item);
	//查询多个商品
	public List<Item> list(List<Integer> list);
}
