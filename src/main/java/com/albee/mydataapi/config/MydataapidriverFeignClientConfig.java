package com.albee.mydataapi.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class MydataapidriverFeignClientConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Accept", "application/json");
        };
    }
}
