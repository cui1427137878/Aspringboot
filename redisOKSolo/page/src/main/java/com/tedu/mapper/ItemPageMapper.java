package com.tedu.mapper;

import com.tedu.pojo.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

//分页
@Mapper
public interface ItemPageMapper {
    public List<Item> selectPage();
}
