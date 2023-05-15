package com.aws.image.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsImageUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsImageUploadApplication.class, args);
		System.err.println("Application Started");
	}

}
