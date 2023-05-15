package com.aws.image.upload.profile;

import java.util.Objects;
import java.util.UUID;

public class UserProfile {
	
	private UUID userProfileId;
	private String userName;
	private String userProfileImageLink;	//s3 key
	public UserProfile(UUID userProfileId, 
					   String userName, 
					   String userProfileImageLink) {
		this.userProfileId = userProfileId;
		this.userName = userName;
		this.userProfileImageLink = userProfileImageLink;
	}
	public UUID getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(UUID userProfileId) {
		this.userProfileId = userProfileId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserProfileImageLink() {
		return userProfileImageLink;
	}
	public void setUserProfileImageLink(String userProfileImageLink) {
		this.userProfileImageLink = userProfileImageLink;
	}
	@Override
	public int hashCode() {
		return Objects.hash(userName, userProfileId, userProfileImageLink);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		return Objects.equals(userName, other.userName) && 
			   Objects.equals(userProfileId, other.userProfileId) && 
			   Objects.equals(userProfileImageLink, other.userProfileImageLink);
	}
	
	

}
