package com.example.server.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class SentinelController {

    @GetMapping("/sentinel1")
    public String sentinel1(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "sentinel1";
    }

    @GetMapping("/sentinel2")
    public String sentinel2(){
        return "sentinel2 测试高并发";
    }
}
