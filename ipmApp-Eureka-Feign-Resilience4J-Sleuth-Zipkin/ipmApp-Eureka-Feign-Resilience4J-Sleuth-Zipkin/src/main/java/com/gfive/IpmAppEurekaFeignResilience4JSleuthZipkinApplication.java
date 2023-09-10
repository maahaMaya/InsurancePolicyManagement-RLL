package com.gfive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableFeignClients
@SpringBootApplication
public class IpmAppEurekaFeignResilience4JSleuthZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpmAppEurekaFeignResilience4JSleuthZipkinApplication.class, args);
	}
	
	@Bean
	public Sampler getSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
