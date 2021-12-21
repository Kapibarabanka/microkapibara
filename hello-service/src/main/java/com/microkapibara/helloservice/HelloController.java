package com.microkapibara.helloservice;

import com.microkapibara.helloservice.py_client.PyClientImpl;
import com.microkapibara.helloservice.service.HelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
	@Autowired
	private PyClientImpl pyClient;

	@Autowired
	private HelloService helloService;
	
    @RequestMapping(value = "/java-hello", method = RequestMethod.GET)
    @ResponseBody
	public String getHello() {
		String greeting = helloService.getJavaHello();
		String updatedGreeting = pyClient.processGreeting(greeting);
		System.out.println("JAVA_LOG: Java did its job");
		return updatedGreeting;
	}
}
