package com.jetherrodrigues.unisal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDisc
@EnableAutoConfiguration
@SpringBootApplication
public class MonoliticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonoliticoApplication.class, args);
	}

}
