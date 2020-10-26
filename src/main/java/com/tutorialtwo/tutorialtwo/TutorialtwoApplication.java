package com.tutorialtwo.tutorialtwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.tutorialtwo.tutorialtwo.repository")
@EntityScan("com.tutorialtwo.tutorialtwo.domain")
@SpringBootApplication
public class TutorialtwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialtwoApplication.class, args);
	}

}
