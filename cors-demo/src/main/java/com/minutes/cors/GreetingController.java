package com.minutes.cors;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	
    private final AtomicLong counter = new AtomicLong();
    
    @CrossOrigin(origins="http://localhost:9000")
	@GetMapping("/greeting")
	public Greeting greet(@RequestParam(required=false, defaultValue="world") String name) {
		
		Greeting greeting = new Greeting(counter.incrementAndGet(), "Hello "+name);
		return greeting;
	}
}
