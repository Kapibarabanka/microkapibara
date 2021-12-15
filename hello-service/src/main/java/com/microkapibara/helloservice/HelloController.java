package com.microkapibara.helloservice;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
	public String getHello() {
		return "HELLO FROM FUCKING SERVICES";
	}
}
