package com.gfive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class IpmAppEurekaFeignResilience4JSleuthZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpmAppEurekaFeignResilience4JSleuthZipkinApplication.class, args);
	}

}
