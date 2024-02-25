package com.example.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.Order;
import com.example.server.mapper.OrderMapper;
import com.example.server.service.OrderService;
import org.example.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order createOrder(Long pid, Long uid) {
        Order order = new Order();
        order.setPid(pid);
        String url  = "http://localhost:8081/product/" + pid;
        Product product = restTemplate.getForObject(url, Product.class);
        order.setProductName(product.getName());
        order.setProductPrice(product.getPrice());
        order.setUid(uid);
        order.setUsername("zhangsan");
        order.setNumber(1);
        super.save(order);
        return order;
    }
}
