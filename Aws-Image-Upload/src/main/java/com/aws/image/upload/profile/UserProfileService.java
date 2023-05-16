package com.aws.image.upload.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.aws.image.upload.datastore.FakeUserProfileDataStore;

@Service
public class UserProfileService {
	
	private final UserProfileDataAccessService userProfileDataAccessService;

	@Autowired
	public UserProfileService(UserProfileDataAccessService userProfileDataAccessService) {
		this.userProfileDataAccessService = userProfileDataAccessService;
	}
	
	List<UserProfile> getUserProfiles() {
		return userProfileDataAccessService.getUserProfiles();
	}
	

}
