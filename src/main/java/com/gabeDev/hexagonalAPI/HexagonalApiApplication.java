package com.gabeDev.hexagonalAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HexagonalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalApiApplication.class, args);
	}

}
