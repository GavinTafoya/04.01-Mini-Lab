package com.example.minilab.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.context.annotation.Configuration;

@Configuration 
public class CanvasConfig {
    @Value("${canvas.api.base-url}")
    private String baseUrl;

    @Value("${canvas.api.token}")
    private String token;

    @Bean
    public WebClient canvasWebClient() {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
