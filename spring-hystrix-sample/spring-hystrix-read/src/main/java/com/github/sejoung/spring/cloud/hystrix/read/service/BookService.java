package com.github.sejoung.spring.cloud.hystrix.read.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RefreshScope
@Service
public class BookService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${recommended.url}")
	private String url;

	public String readingList() {
		return restTemplate.getForObject(url, String.class);
	}

	@HystrixCommand(fallbackMethod = "reliable")
	public String hystrixReadingList() {
		return restTemplate.getForObject(url, String.class);
	}

	public String reliable() {
		return "Cloud Native Java (O'Reilly)";
	}
}