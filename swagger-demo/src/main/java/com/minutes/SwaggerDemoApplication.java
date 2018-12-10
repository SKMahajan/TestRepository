package com.minutes;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerDemoApplication.class, args);
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.minutes.swagger"))
				.build()
				.apiInfo(metaData())
				.produces(new HashSet<>(Arrays.asList("application/json","application/xml")))
				.consumes(new HashSet<>(Arrays.asList("application/json","application/xml")));
	}
	
	private ApiInfo metaData() {
		ApiInfo info = new ApiInfo("API Title", "API Description", "Version 2.0", 
				"Terms of service URL", "Contact number", "License", "License URL");
		return info;
	}
}
