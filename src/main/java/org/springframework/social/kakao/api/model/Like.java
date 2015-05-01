package org.springframework.social.kakao.api.model;


import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;


@Data
public class Like {

	public static enum Emotion {
		LIKE, COOL, HAPPY, SAD, CHEER_UP, NOT_DEFINED;
	}

	@JsonProperty("emotion")
	private Emotion	emotion;

	@JsonProperty("actor")
	private Actor	actor;


}
