package com.qa.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class AnimalKingdomHwaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalKingdomHwaApplication.class, args);
	}

}
