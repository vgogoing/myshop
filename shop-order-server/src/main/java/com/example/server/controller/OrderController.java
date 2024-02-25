package com.example.server.controller;

import com.example.domain.Order;
import com.example.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("save")
    public Order createOrder(Long pid, Long uid){
        return orderService.createOrder(pid, uid);
    }

}
