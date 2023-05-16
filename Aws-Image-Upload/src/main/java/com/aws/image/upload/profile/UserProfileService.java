package com.aws.image.upload.profile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aws.image.upload.bucket.BucketName;
import com.aws.image.upload.filestore.FileStore;

@Service
public class UserProfileService {
	
	private final UserProfileDataAccessService userProfileDataAccessService;
	
	private final FileStore fileStore;

	@Autowired
	public UserProfileService(UserProfileDataAccessService userProfileDataAccessService, FileStore fileStore) {
		this.userProfileDataAccessService = userProfileDataAccessService;
		this.fileStore = fileStore;
	}
	
	List<UserProfile> getUserProfiles() {
		return userProfileDataAccessService.getUserProfiles();
	}

	public Object uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
		// 1.If file is empty
		if(file.isEmpty()) {
			throw new IllegalStateException("Can't upload empty file [" + file.getSize() + "]");
		}
		
		// 2.File must be Image
		if(!Arrays.asList(ContentType.IMAGE_JPEG.getMimeType(),ContentType.IMAGE_PNG.getMimeType(),ContentType.IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
			throw new IllegalStateException("File must be an image["+ file.getContentType() +"]");
		}
		
		// 3.The user exists in database
		UserProfile user = userProfileDataAccessService
				.getUserProfiles()
				.stream()
				.filter(userProfile -> userProfile.getUserProfileId().equals(userProfileId))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException(String.format("user profile %s not found", userProfileId)));
		
		// 4.Grab some meta data from file if any
		Map<String, String> metadata = new HashMap<>();
		metadata.put("content-Type", file.getContentType());
		metadata.put("content-Length", String.valueOf(file.getSize()));
		
		// 5.Store image in the s3 and update the database (userProfileImageLink) with s3 image link
		String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), user.getUserProfileId());
		String filename = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());
		
		try {
			fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
			user.setUserProfileImageLink(filename);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
		return null;
	}

	byte[] downloadUserProfileImage(UUID userProfileId) {
		UserProfile user = userProfileDataAccessService
				.getUserProfiles()
				.stream()
				.filter(userProfile -> userProfile.getUserProfileId().equals(userProfileId))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException(String.format("user profile %s not found", userProfileId)));
		
		String path = String.format("%s/%s",
				BucketName.PROFILE_IMAGE.getBucketName(),
				user.getUserProfileId());
		
		return user.getUserProfileImageLink()
                .map(key -> fileStore.download(path, key))
                .orElse(new byte[0]);
	}
	

}
