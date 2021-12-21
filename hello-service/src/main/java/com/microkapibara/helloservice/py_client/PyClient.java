package com.microkapibara.helloservice.py_client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "py-service", fallback = PyClientFallback.class)
public interface PyClient {
    @RequestMapping("/py-hello/process-hello/{greeting}")
    public String processGreeting(@PathVariable("greeting") String greeting);
}