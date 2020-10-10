package com.spring.springbeandemo.config;

public interface UserMapper {

    @ConfigSql(value = "select * from user")
    void getAll();
}
