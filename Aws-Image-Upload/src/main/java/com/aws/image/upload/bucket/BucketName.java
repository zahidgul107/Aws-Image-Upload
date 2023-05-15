package com.aws.image.upload.bucket;

public enum BucketName {
	
	PROFILE_IMAGE("spring-boot-image-upload-123");
	
	private final String bucketName;

	private BucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getBucketName() {
		return bucketName;
	}

}
