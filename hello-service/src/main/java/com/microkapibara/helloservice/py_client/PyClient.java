package com.microkapibara.helloservice.py_client;

import com.google.common.util.concurrent.RateLimiter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "py-service", fallback = PyClientFallback.class)
public interface PyClient {
    final RateLimiter rateLimiter = RateLimiter.create(1.0);
    @RequestMapping("/py-hello/process-hello/{greeting}")
    public String processGreeting(@PathVariable("greeting") String greeting);
}
