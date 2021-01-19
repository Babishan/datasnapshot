package com.codingtask.datasnapshot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DatasnapshotApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatasnapshotApplication.class, args);
	}

}
