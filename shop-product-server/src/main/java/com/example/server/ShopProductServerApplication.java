package com.example.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.example.server.mapper")
@EnableDiscoveryClient
public class ShopProductServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopProductServerApplication.class, args);
    }

}
