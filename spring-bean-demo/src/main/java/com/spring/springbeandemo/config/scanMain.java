package com.spring.springbeandemo.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class scanMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(UserService.class).all();
    }
}
