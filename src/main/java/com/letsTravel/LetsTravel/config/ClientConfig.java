package com.letsTravel.LetsTravel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration
public class ClientConfig {

    @Bean
    public HttpClient appleMapClient() {
        return HttpClient.newBuilder().build();
    }

}
