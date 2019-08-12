package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.example.demo.model.Store;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class StoreConfig {

	@Bean
	public Store chennai() {
		return new Store(102,"palladium","reddy",5000000.00D);
		
	}
	
	@Bean
	public Store bangalore() {
		return new Store(103,"gopalan","kumar",7500000.00D);
		
	}
	
	@Bean
	public Store pune() {
		return new Store(104,"abc","pqr",2500000.00D);
		
	}
	
	@Bean
	public Docket api() {
		
		
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}
	
	public void addResourceHandler(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
