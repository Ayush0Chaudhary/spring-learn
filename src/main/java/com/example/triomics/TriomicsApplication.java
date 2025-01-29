package com.example.triomics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TriomicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriomicsApplication.class, args);
	}

}
