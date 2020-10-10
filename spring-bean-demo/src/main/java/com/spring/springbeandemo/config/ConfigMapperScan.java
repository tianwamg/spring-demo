package com.spring.springbeandemo.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Import(ConfigMapperScanRegister.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigMapperScan {
    String value();
}
