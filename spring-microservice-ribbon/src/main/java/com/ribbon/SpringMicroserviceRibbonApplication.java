package com.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name="spring-simple-service",configuration=ServiceConfiguration.class)
public class SpringMicroserviceRibbonApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/start")
	public String start() {
		//return this.restTemplate.getForObject("http://localhost:9991/execute", String.class);
		return restTemplate.getForObject("http://spring-simple-service/execute", String.class);
	}
	
	@GetMapping("/test")
	public String test() {
		return "up";
		//return restTemplate.getForObject("http://spring-simple-service/execute", String.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceRibbonApplication.class, args);
	}
}
