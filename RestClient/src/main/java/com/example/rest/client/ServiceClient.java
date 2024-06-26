package com.example.rest.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component 
public class ServiceClient {
	
	@Bean
	public RestTemplate genrateRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}

