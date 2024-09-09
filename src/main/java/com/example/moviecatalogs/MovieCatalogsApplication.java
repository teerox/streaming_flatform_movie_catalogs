package com.example.moviecatalogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieCatalogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogsApplication.class, args);
	}

}
