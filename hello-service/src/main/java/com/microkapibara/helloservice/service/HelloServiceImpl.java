package com.microkapibara.helloservice.service;

import java.util.concurrent.TimeUnit;

import com.weddini.throttling.Throttling;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    @Throttling(limit = 5, timeUnit = TimeUnit.MINUTES)
    public String getJavaHello() {
        return "Hello from java";
    }
    
}
