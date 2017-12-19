package com.github.sejoung.spring.cloud.hystrix.read;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author kim se joung
 *
 */
@EnableHystrixDashboard
@EnableCircuitBreaker
@SpringBootApplication
public class HystrixReadApplication {
	public static void main(String[] args) {
		SpringApplication.run(HystrixReadApplication.class, args);
	}
}
