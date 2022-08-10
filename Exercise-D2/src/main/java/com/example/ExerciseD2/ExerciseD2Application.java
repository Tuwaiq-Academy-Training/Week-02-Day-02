package com.example.ExerciseD2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class ExerciseD2Application {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseD2Application.class, args);


		}
	@Bean
	public int Test(){
		System.out.println("INT TEST");
		return 0;
	}
	@Bean
	public String Test2()
			{
				System.out.println("STRING TEST");
				return "STRING TEST";
			}

		}

