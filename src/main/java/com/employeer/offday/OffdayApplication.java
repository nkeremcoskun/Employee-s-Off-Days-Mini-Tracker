package com.employeer.offday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class OffdayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OffdayApplication.class, args);
	}

}
