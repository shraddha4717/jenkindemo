package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudLaptopApplication {

	public static void main(String[] args) {
		System.out.println("starts");
		SpringApplication.run(SpringBootCrudLaptopApplication.class, args);
		System.out.println("ends");
	}

}
