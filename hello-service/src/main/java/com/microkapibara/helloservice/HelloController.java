package com.microkapibara.helloservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
	@Autowired
	PyClient pyClient;
	
    @RequestMapping(value = "/java-hello", method = RequestMethod.GET)
    @ResponseBody
	public String getHello() {
		String greeting = "Hello from java";
		String updatedGreeting = pyClient.processGreeting(greeting);
		return updatedGreeting;
	}
}
