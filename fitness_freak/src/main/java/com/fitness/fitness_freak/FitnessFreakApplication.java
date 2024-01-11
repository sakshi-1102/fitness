package com.fitness.fitness_freak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FitnessFreakApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnessFreakApplication.class, args);
		System.out.print("Welcome to Fitness Freak");
	}

}
