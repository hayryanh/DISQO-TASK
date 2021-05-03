package com.data.agent.service;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
@ComponentScan("com.data.agent")
public class ServiceConfiguration {

    @Bean
    OkHttpClient okHttpClient() {
        return new OkHttpClient().newBuilder().build();
    }

    @Bean
    MediaType mediaType() {
        return MediaType.parse("application/json");
    }

    @Bean
    RequestInterceptor authRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                requestTemplate.header("Content-Type", "application/json");
            }
        };
    }
}
