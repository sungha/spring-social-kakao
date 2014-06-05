package org.springframework.social.kakao.api.model;


import java.net.URL;

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
	private URL			profile;

	@JsonProperty("thumbnailURL")
	private URL			thumbnail;

	@JsonProperty("bgImageURL")
	private URL			background;

	@JsonProperty("birthday")
	private String			birthday;

	@JsonProperty("birthdayType")
	private BirthdayType	birthdayType;


}
