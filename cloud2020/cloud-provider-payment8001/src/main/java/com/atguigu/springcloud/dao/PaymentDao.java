/*
* 1.使用@Mapper将NewsDAO接口交给Spring进行管理

2.不用写Mapper映射文件（XML）

3.为这个NewsDAO接口生成一个实现类，让别的类进行引用
* */
package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @auther zzyy
 * @create 2020-02-18 10:27
 */
@Mapper
@Repository
public interface PaymentDao
{
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") int id);
}


