package org.springframework.social.kakao.api.model;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;


@Data
public class Actor {

	@JsonProperty("display_name")
	private String displayName;
	
	@JsonProperty("profile_thumbnail_url")
	private String profileThumbnailUrl;
	

}
