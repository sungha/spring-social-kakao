package org.springframework.social.kakao.api.model;


import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * <pre>
 * 카카오톡 프로필
 * </pre>
 * 
 * @author sungha
 */
@Data
public class KakaoTalkProfile {

	/** 닉네임 */
	@JsonProperty("nickName")
	private String	nickname;

	/** 프로필 이미지 원본 URL */
	@JsonProperty("profileImageURL")
	private String	profile;

	/** 프로필 이미지 썸네일 URL */
	@JsonProperty("thumbnailURL")
	private String	thumbnail;

	/** 국가 */
	@JsonProperty("countryISO")
	private String	country;

}
