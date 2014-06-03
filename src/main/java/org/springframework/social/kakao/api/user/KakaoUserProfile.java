package org.springframework.social.kakao.api.user;


import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class KakaoUserProfile {

	@JsonProperty("id")
	private Integer		id;

	@JsonProperty("properties")
	private Properties	properties	= new Properties();

	
	public String getNickname() {
		return getProperties().getNickname();
	}

	public String getThumbnail() {
		return getProperties().getThumbnail();
	}

	public String getProfile() {
		return getProperties().getProfile();
	}

	
	@JsonAutoDetect
	@JsonIgnoreProperties(ignoreUnknown = true)
	@Getter
	@Setter
	public class Properties {

		@JsonProperty("nickname")
		private String	nickname;

		@JsonProperty("thumbnail_image")
		private String	thumbnail;

		@JsonProperty("profile_image")
		private String	profile;

	}

}
