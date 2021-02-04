package com.tedu;

import org.springmvc.RequestMapping;
import org.springmvc.RestController;

@RestController
public class OrderController {

    @RequestMapping("/order")
    public  OrderEntity select(){
        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setOrderId(20200000);
        orderEntity.setTotal(9000);
        return  orderEntity;
    }
}
