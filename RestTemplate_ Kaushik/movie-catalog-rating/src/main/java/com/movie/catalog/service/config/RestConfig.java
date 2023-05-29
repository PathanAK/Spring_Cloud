package com.movie.catalog.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RestConfig {
	
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public WebClient.Builder getWebclientbuilder() {
		return WebClient.builder();
	}
}
