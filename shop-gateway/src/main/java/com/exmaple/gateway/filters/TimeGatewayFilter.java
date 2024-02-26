package com.exmaple.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class TimeGatewayFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        long begin = System.currentTimeMillis();
        System.out.println("前置当前时间:" + begin);
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            long end = System.currentTimeMillis();
            System.out.println("后置当前时间" + end);
            System.out.println("两者时间差:" + (end - begin));
        })) ;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
