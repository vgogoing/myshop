package com.example.server.feign;

import org.example.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product-service")
public interface ProductFeignService {
    @GetMapping("/product/{pid}")
    Product getById(@PathVariable("pid") Long pid);
}
