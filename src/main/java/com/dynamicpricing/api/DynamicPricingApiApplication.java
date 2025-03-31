package com.dynamicpricing.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.dynamicpricing.api")
public class DynamicPricingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicPricingApiApplication.class, args);
	}

}
