package com.microkapibara.helloservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping(path = "/my_hello", method = RequestMethod.GET)
	public String getHello() {
		return "HELLO FROM FUCKING SERVICES";
	}
}
