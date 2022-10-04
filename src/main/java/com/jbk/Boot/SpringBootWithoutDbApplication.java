package com.jbk.Boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWithoutDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithoutDbApplication.class, args);
		System.out.println("Hello");
	}

}
