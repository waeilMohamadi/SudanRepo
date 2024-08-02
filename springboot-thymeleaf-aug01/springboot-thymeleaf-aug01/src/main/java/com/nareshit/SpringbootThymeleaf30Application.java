package com.nareshit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootThymeleaf30Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootThymeleaf30Application.class, args);
	}

}
