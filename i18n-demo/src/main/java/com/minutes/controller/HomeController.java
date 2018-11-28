package com.minutes.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	private MessageSource ms;
	
	@GetMapping("/home")
	public String goodMorningMessage(@RequestHeader(name="accept-language", required=false) Locale locale) {
		return ms.getMessage("good.morning.message",null, locale);
	}
	
}
