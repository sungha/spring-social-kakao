package org.springframework.social.kakao.api.model;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;


@Data
public class Comment {

	@JsonProperty("text")
	private String text;
	
	@JsonProperty("writer")
	private Actor writer;
	

}
