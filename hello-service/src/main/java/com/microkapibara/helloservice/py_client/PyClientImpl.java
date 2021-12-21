package com.microkapibara.helloservice.py_client;

import com.google.common.util.concurrent.RateLimiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PyClientImpl implements PyClient{
    final RateLimiter rateLimiter = RateLimiter.create(4.0 / 60.0);
    
    @Autowired
    PyClient client;

    @Override
    public String processGreeting(String greeting) {
        rateLimiter.acquire();
        return client.processGreeting(greeting);
    }
    
}
