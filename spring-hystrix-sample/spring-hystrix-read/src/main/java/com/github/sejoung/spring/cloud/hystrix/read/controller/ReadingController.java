package com.github.sejoung.spring.cloud.hystrix.read.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sejoung.spring.cloud.hystrix.read.service.BookService;

@RestController
public class ReadingController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/to-read")
	public String toRead() {
		return bookService.readingList();
	}

}