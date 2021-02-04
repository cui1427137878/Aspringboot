package com.example.mybatis04_plus.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.mybatis04_plus.pojo.Category;

//以前我们要写insert(),delete(),update(),select()
//BaseMapper中有insert(),delete(),update(),select()
public interface CategoryMapper extends BaseMapper<Category>{

}
