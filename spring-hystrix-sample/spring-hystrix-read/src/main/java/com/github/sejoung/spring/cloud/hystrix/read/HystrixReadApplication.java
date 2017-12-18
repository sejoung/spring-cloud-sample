package com.github.sejoung.spring.cloud.hystrix.read;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @author kim se joung
 *
 */
@EnableCircuitBreaker
@SpringBootApplication
public class HystrixReadApplication {
	public static void main(String[] args) {
		SpringApplication.run(HystrixReadApplication.class, args);
	}
}
