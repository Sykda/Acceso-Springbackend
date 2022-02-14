package com.aad.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {

		return args -> {
			Student student1 = new Student("Laura", "laura@gmail.com", 33, LocalDate.of(2019, Month.OCTOBER, 17));

			Student student2 = new Student("Ana", "ana@gmail.com", 29, LocalDate.of(2019, Month.OCTOBER, 22));

			studentRepository.saveAll(List.of(student1, student2));
		};
	}

}
