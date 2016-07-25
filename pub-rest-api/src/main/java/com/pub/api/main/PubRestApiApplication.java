package com.pub.api.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.pub.api" })
@EnableMongoRepositories(basePackages = { "com.pub.api.repository" })
public class PubRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubRestApiApplication.class, args);
	}
}
