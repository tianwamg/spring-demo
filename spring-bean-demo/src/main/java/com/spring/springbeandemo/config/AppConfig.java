package com.spring.springbeandemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ConfigMapperScan("com.spring.springbeandemo.config")
@ComponentScan
@Configuration
public class AppConfig {
    @Bean
    public ServiceImpl getServiceImpl() {
        return new ServiceImpl();
    }

    @Bean
    public OtherImpl getOtherImpl() {
        getServiceImpl();
        return new OtherImpl();
    }
}
