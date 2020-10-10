package com.spring.springbeandemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public void all(){
        userMapper.getAll();
    }
}
