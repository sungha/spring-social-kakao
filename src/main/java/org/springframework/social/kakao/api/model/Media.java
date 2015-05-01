package org.springframework.social.kakao.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class Media {
	
	@JsonProperty("original")
	private String orginal;
	
	@JsonProperty("xlarge")
	private String xlarge;
	
	@JsonProperty("large")
	private String large;
	
	@JsonProperty("medium")
	private String medium;
	
	@JsonProperty("small")
	private String small;

}
