package org.springframework.social.kakao.api.story;


import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class KakaoStoryProfile {

	public static enum BirthdayType {
		SOLAR, LUNAR
	}

	@JsonProperty("nickName")
	private String			nickname;

	@JsonProperty("profileImageURL")
	private String			profile;

	@JsonProperty("thumbnailURL")
	private String			thumbnail;

	@JsonProperty("bgImageURL")
	private String			background;

	@JsonProperty("birthday")
	private String			birthday;

	@JsonProperty("birthdayType")
	private BirthdayType	birthdayType;



}
