package com.example.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.Order;
import com.example.server.feign.ProductFeignService;
import com.example.server.mapper.OrderMapper;
import com.example.server.service.OrderService;
import org.example.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;


@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ProductFeignService productFeignService;

    @Override
    public Order createOrder(Long pid, Long uid) {
        Order order = new Order();
        order.setPid(pid);
//        String url  = "http://localhost:8081/product/" + pid;
//        Product product = restTemplate.getForObject(url, Product.class);
        List<ServiceInstance> instances = discoveryClient.getInstances("product-service");
//        ServiceInstance serviceInstance = instances.get(0);
//        int i = new Random().nextInt(instances.size());
//        ServiceInstance serviceInstance = instances.get(i);
//        String host = serviceInstance.getHost();
//        int port = serviceInstance.getPort();
//        String url = "http://" + host + ":" + port + "/product/" + pid;
//        Product product = restTemplate.getForObject(url, Product.class);
//        System.out.println("从nacos获取地址-----------"+ url);

        //使用ribbon的方式 带负载均衡
//        String url = "http://product-service/product/" + pid;
//        Product product = restTemplate.getForObject(url, Product.class);

        //使用feign远程接口调用
        Product product = productFeignService.getById(pid);

        order.setProductName(product.getName());
        order.setProductPrice(product.getPrice());
        order.setUid(uid);
        order.setUsername("zhangsan");
        order.setNumber(1);
        super.save(order);
        return order;
    }
}
