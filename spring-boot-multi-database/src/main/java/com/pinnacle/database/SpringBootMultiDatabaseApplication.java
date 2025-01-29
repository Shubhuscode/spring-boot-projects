package com.pinnacle.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.pinnacle.database.repository")
public class SpringBootMultiDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultiDatabaseApplication.class, args);
	}

}
