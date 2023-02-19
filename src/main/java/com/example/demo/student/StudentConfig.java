package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository repository) {
		return args -> {
			student mariam=new student( "Mariam", "mariam.gmail.com", LocalDate.of(2000, 1, 5));
			student alex=new student( "Alex", "alex.gmail.com", LocalDate.of(2000, 1, 5));
			repository.saveAll(
					List.of(mariam,alex));
		};
		
	}

}
