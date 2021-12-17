package com.microkapibara.helloservice.py_client;

import org.springframework.stereotype.Component;

@Component
public class PyClientFallback implements PyClient {

    @Override
    public String processGreeting(String greeting) {
        return greeting + "\nSomething went wrong with PyClient :(";
    }
}
