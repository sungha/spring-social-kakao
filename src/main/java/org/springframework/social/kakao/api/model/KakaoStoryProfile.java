package org.springframework.social.kakao.api.model;


import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;


@Data
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
