package org.codingfly.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 鉴权
 */
@Component
public class AuthSignatureFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange ctx, GatewayFilterChain chain) {
        //ServerHttpRequest request = ctx.getRequest();
        return chain.filter(ctx);
    }

    @Override
    public int getOrder() {
        return -400;
    }
}
