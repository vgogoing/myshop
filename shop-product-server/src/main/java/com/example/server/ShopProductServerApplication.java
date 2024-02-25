package com.example.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.example.server.mapper")
public class ShopProductServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopProductServerApplication.class, args);
    }

}
