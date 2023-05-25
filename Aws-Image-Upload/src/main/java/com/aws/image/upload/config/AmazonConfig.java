package com.aws.image.upload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfig {
	
/*	@Bean
	public AmazonS3 s3() {
		AWSCredentials awsCredentials = new BasicAWSCredentials("", "");
		
		return AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.build();
	}  */
	
/*	@Bean
	public AmazonS3 s3() {
	    AWSCredentials credentials = new BasicAWSCredentials("", "");
	    AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
	            .withCredentials(new AWSStaticCredentialsProvider(credentials))
	            .withRegion(Regions.AP_SOUTH_1) // Set your desired region here
	            .build();
	    return s3Client;
	} */


}
