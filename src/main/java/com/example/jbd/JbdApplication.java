package com.example.jbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan //scan the app for any custom configuration
public class JbdApplication {

	public static void main(String[] args) {
		SpringApplication.run(JbdApplication.class, args);
	}

}
