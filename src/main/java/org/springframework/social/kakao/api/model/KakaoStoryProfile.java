package org.springframework.social.kakao.api.model;


import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 카카오스토리 프로필
 * 
 * @author sungha
 */
@Data
public class KakaoStoryProfile {

	public static enum BirthdayType {
		SOLAR, LUNAR
	}

	/** 대화명 */
	@JsonProperty("nickName")
	private String			nickname;

	/** 프로필 이미지 URL */
	@JsonProperty("profileImageURL")
	private String			profile;

	/** 프로필 썸네일 이미지 URL */
	@JsonProperty("thumbnailURL")
	private String			thumbnail;

	/** 배경 이미지 URL */
	@JsonProperty("bgImageURL")
	private String			background;

	/** 카카오스토리 주소 */
	@JsonProperty("permalink")
	private String			permalink;
	
	/** 생일 MMDD */
	@JsonProperty("birthday")
	private String			birthday;

	/** 생일 양력/음력(SOLAR | LUNAR) */
	@JsonProperty("birthdayType")
	private BirthdayType	birthdayType;



}
