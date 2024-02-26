package com.example.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.example.server.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class ShopOrderServceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopOrderServceApplication.class, args);
    }

//    @Bean
//    @LoadBalanced //使用ribbon组件
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
}
