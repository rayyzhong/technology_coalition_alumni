package com.coalition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.coalition")
public class CoalitionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoalitionApplication.class, args);
	}

}
