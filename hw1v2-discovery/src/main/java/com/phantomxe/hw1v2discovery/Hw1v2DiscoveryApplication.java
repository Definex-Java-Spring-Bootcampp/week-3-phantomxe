package com.phantomxe.hw1v2discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Hw1v2DiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hw1v2DiscoveryApplication.class, args);
	}

}
