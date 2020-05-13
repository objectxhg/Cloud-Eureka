package com.xhg.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaClient
@EnableEurekaServer
@SpringBootApplication
public class PeerEureka1Application {

	public static void main(String[] args) {
		SpringApplication.run(PeerEureka1Application.class, args);
	}

}
