package com.github.sejoung.spring.cloud.hystrix.read.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sejoung.spring.cloud.hystrix.read.service.BookService;

@RestController
public class ReadingController {

	@Autowired
	private BookService bookService;

	@GetMapping("/to-read")
	public String toRead() {
		return bookService.readingList();
	}
	
	@GetMapping("/to-read-hystrix")
	public String toReadHystrix() {
		return bookService.hystrixReadingList();
	}

}