package com.jfive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class IpmAppEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpmAppEurekaServerApplication.class, args);
		System.out.println("Server started...IpmAppEurekaServerApplication");
	}
}
