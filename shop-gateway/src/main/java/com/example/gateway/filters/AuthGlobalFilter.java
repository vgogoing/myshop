package com.example.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class AuthGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
        String token = queryParams.getFirst("token");
        ServerHttpResponse response = exchange.getResponse();
        if (!StringUtils.hasText(token)){
            System.out.println("没有登录");
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            return response.setComplete();

            String ret = "{\"code\":401, \"msg\":\"没有登录\", \"data\":\"\"}";
            byte[] bits = ret.getBytes(StandardCharsets.UTF_8);
            //把字节数据转换成一个DataBuffer
            DataBuffer buffer = response.bufferFactory().wrap(bits);
            return response.writeWith(Mono.just(buffer));
        }
        return chain.filter(exchange);
    }
}
