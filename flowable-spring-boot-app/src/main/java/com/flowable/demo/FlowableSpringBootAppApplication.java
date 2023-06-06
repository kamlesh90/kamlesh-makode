package com.flowable.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.flowable.demo.service.PersonService;

@SpringBootApplication
public class FlowableSpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowableSpringBootAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(final PersonService personService) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				personService.createUser();
			}
		};
	}
}
