package org.example.contributetolearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ContributeToLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContributeToLearningApplication.class, args);
	}

}
