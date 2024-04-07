package com.omnie.forms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DynamicFormApp {
	public static void main(String[] args) {
		SpringApplication.run(DynamicFormApp.class, args);
	}
}
