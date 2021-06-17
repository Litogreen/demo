package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public WebClient goodsApiClient() {
		return WebClient.create( "http://18.183.144.77:8080" );
	}

	@Bean
	public WebClient orderApiClient() {
		return WebClient.create( "http://18.183.144.77:8081" );
	}
}
