package com.lab.mspartner;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.retry.annotation.EnableRetry;

@EnableRabbit
@EnableRetry
@EnableCaching
@SpringBootApplication
public class PartnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartnerApplication.class, args);
	}

}
