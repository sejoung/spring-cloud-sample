package com.github.sejoung.spring.cloud.hystrix.source.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookstoreController {
	
	@RequestMapping(value = "/recommended")
	public String readingList() {
		return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
	}
	
}
