package com.microkapibara.helloservice;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping(value = "/my_hello", method = RequestMethod.GET)
    @ResponseBody
	public String getHello() {
		return "HELLO FROM FUCKING SERVICES";
	}
}
