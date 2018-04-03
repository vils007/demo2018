package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class Demo2018Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2018Application.class, args);
	}
}
