package org.springframework.social.kakao.api.model;


import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * <pre>
 * 카카오 프로필
 * </pre>
 * 
 * @author sungha
 */
@Data
public class KakaoUserProfile {

	/** 사용자 고유식별번호 */
	@JsonProperty("id")
	private Integer				id;

	/** 사용자 속성 정보 */
	@JsonProperty("properties")
	private final Properties	properties;


	public KakaoUserProfile() {
		this.properties = new Properties();
	}



	public String getNickname() {
		return getProperties().getNickname();
	}

	public String getThumbnail() {
		return getProperties().getThumbnail();
	}

	public String getProfile() {
		return getProperties().getProfile();
	}


	/**
	 * <pre>
	 * 사용자 상세 속성 정보
	 * </pre>
	 * 
	 * @author sungha
	 */
	@Data
	public static class Properties {

		/** 대화명 */
		@JsonProperty("nickname")
		private String	nickname;

		/** 프로필 이미지 원본 URL */
		@JsonProperty("profile_image")
		private String	profile;

		/** 프로필 이미지 썸네일 URL */
		@JsonProperty("thumbnail_image")
		private String	thumbnail;

	}

}
