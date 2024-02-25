package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Order;

public interface OrderService extends IService<Order> {
    Order createOrder(Long pid, Long uid);
}
