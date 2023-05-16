package com.aws.image.upload.datastore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.aws.image.upload.profile.UserProfile;


@Repository
public class FakeUserProfileDataStore {
	
	private static final List<UserProfile> USER_PROFILES = new ArrayList<>();
	
	static {
		USER_PROFILES.add(new UserProfile(UUID.fromString("012f0030-d02c-4264-809d-c7fe62f619e4"), "Zahid Gul", null));
		USER_PROFILES.add(new UserProfile(UUID.fromString("61490f9e-31be-4f9d-86bf-4aa637607901"), "John Doe", null));
	}
	
	public List<UserProfile> getUserProfiles() {
		return USER_PROFILES;
	}

}
