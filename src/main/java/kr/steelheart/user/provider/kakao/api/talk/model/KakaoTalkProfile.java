package kr.steelheart.user.provider.kakao.api.talk.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoTalkProfile {

	@JsonProperty("nickName")
	private String	nickname;

	@JsonProperty("thumbnailURL")
	private String	thumbnail;

	@JsonProperty("profileImageURL")
	private String	profile;

	@JsonProperty("countryISO")
	private String	country;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(final String nickname) {
		this.nickname = nickname;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(final String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(final String profile) {
		this.profile = profile;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

}
