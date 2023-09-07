package com.jfive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class IpmAppConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpmAppConfigServerApplication.class, args);
		System.out.println("Server is started....IpmAppConfigServerApplication");
	}

}
