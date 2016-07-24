package com.pub.api.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.pub.api" })
public class PubRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubRestApiApplication.class, args);
	}
}
