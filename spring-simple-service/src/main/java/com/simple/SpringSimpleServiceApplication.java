package com.simple;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringSimpleServiceApplication {

	@Value("${server.port}")
	private String port;
	
	@GetMapping("/execute")
	public String execute() {
		return "result from port "+port;
	}
	
	@RequestMapping("/")
	public String status() {
		return "Up";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSimpleServiceApplication.class, args);
	}
}
