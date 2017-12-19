package com.github.sejoung.spring.cloud.hystrix.read.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

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

	@HystrixCommand(fallbackMethod = "reliable", 
			commandProperties = { 
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
					}, 
			threadPoolProperties = { 
					@HystrixProperty(name = "coreSize", value = "30"), 
					@HystrixProperty(name = "maxQueueSize", value = "101"), 
					@HystrixProperty(name = "keepAliveTimeMinutes", value = "2"), 
					@HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"), 
					@HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"), 
					@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440") 
					})
	public String hystrixReadingList() {
		return restTemplate.getForObject(url, String.class);
	}

	public String reliable() {
		return "Cloud Native Java (O'Reilly)";
	}
}