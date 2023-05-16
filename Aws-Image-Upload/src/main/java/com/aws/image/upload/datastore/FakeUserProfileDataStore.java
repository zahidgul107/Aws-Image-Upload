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
		USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "janetjones", null));
		USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "janetjones", null));
		USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "janetjones", null));
	}
	
	public List<UserProfile> getUserProfiles() {
		return USER_PROFILES;
	}

}
