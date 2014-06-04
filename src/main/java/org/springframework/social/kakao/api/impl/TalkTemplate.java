package org.springframework.social.kakao.api.impl;


import org.springframework.social.kakao.api.TalkOperations;
import org.springframework.social.kakao.api.model.KakaoTalkProfile;


public final class TalkTemplate extends AbstractKakaoOperations implements TalkOperations {

	public TalkTemplate(final String accessToken) {
		super(accessToken);
	}


	@Override
	public KakaoTalkProfile getProfile() {
		return getRestTemplate().getForObject(buildUri("/v1/api/talk/profile"), KakaoTalkProfile.class);
	}


}
