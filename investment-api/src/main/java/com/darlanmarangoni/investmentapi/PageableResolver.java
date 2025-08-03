package com.darlanmarangoni.investmentapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.reactive.BindingContext;
import org.springframework.web.reactive.result.method.HandlerMethodArgumentResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Configuration
public class PageableResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Pageable.class);
    }

    @Override
    public Mono<Object> resolveArgument(MethodParameter parameter, BindingContext bindingContext, ServerWebExchange exchange) {
        String pageStr = exchange.getRequest().getQueryParams().getFirst("page");
        String sizeStr = exchange.getRequest().getQueryParams().getFirst("size");

        int page = (pageStr != null) ? Integer.parseInt(pageStr) : 0;
        int size = (sizeStr != null) ? Integer.parseInt(sizeStr) : 10;

        return Mono.just(PageRequest.of(page, size));
    }
}
