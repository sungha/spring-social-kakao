package org.springframework.social.kakao.api.talk;


import java.net.URL;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class KakaoTalkProfile {

	@JsonProperty("nickName")
	private String	nickname;

	@JsonProperty("thumbnailURL")
	private URL		thumbnail;

	@JsonProperty("profileImageURL")
	private URL		profile;

	@JsonProperty("countryISO")
	private String	country;

}
