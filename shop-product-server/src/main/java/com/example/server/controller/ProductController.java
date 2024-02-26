package com.example.server.controller;

import com.alibaba.fastjson.JSON;
import com.example.server.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/product/{pid}")
    public Product findById(@PathVariable("pid") Long pid){
        log.info("查询{}号商品", pid);
        Product product = productService.getById(pid);
        product.setName(product.getName()+ "-"+port);
        log.info("查询商品成功,为{}", JSON.toJSONString(product));
        return product;
    }

}
