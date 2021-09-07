package org.ximure.technokratos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TechnokratosApplication {
	public static void main(String[] args) {
		SpringApplication.run(TechnokratosApplication.class, args);
	}
}
