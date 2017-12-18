package com.github.sejoung.spring.cloud.eureka.client.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageRestController {

	@Value("${config.name}")
	String name = "World";

	@RequestMapping("/message")
	public String home() {
		return "Hello " + name;
	}
	
}
	