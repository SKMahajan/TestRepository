package com.minutes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.minutes.Greeting;

@RestController
public class Controller {

	@GetMapping("/restClient")
	public String getResponse() {
		
		RestTemplate rt = new RestTemplate();
		Greeting gr = rt.getForObject("http://localhost:8080/greeting?name=suchu", Greeting.class);
		return gr.getContent();
	}
	
}
