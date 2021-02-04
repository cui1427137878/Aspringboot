package com.tedu.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
@Service//发布出去
@Component//放在服务中
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "javajavajava";
    }
}
