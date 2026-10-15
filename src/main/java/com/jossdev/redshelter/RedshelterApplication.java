package com.jossdev.redshelter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class RedshelterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedshelterApplication.class, args);
	}

}