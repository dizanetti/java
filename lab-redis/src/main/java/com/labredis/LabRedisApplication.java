package com.labredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class LabRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabRedisApplication.class, args);
	}

}
