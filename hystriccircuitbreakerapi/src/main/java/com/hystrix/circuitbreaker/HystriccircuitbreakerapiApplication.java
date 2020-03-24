package com.hystrix.circuitbreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
public class HystriccircuitbreakerapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystriccircuitbreakerapiApplication.class, args);
	}

}
