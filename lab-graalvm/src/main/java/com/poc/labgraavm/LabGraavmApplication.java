package com.poc.labgraavm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class LabGraavmApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabGraavmApplication.class, args);
	}

}
