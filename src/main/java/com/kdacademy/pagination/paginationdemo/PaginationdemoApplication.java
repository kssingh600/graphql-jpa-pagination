package com.kdacademy.pagination.paginationdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;

@SpringBootApplication
public class PaginationdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaginationdemoApplication.class, args);
	}

	@Bean
	public Faker faker() {
		return new Faker();
	}
}
