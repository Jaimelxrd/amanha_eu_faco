package com.dev.lxrd.AmanhaEuFaco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AmanhaEuFacoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmanhaEuFacoApplication.class, args);
	}

}
