package com.ironlogic.ironlogic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class IronlogicApplication {

	public static void main(String[] args) {
		SpringApplication.run(IronlogicApplication.class, args);
	}

}
