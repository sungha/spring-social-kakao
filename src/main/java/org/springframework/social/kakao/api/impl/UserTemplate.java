package org.springframework.social.kakao.api.impl;

import org.springframework.social.kakao.api.UserOperations;
import org.springframework.social.kakao.api.model.KakaoUserProfile;




public class UserTemplate extends AbstractKakaoOperations implements UserOperations {

	public UserTemplate(final String accessToken) {
		super(accessToken);
	}


	@Override
	public KakaoUserProfile getProfile() {
		return getRestTemplate().getForObject(buildUri("/v1/user/me"), KakaoUserProfile.class);
	}


}
