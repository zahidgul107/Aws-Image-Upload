package com.aws.image.upload.profile;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user-profile")
public class UserProfileController {
	
	@GetMapping
	public List<UserProfile> getUserProfiles() {
		return null;
	}

}
