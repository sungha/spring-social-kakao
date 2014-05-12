package org.springframework.social.kakao.api.user;


import org.springframework.social.kakao.api.AbstractKakaoOperations;


public class UserTemplate extends AbstractKakaoOperations implements UserOperations {

	private static final String	PROFILE_REQUEST_URL	= API_HOST + "/v1/user/me";


	public UserTemplate(final String accessToken) {
		super(accessToken);
	}


	@Override
	public KakaoUserProfile getProfile() {
		return getRestTemplate().getForObject(PROFILE_REQUEST_URL, KakaoUserProfile.class);
	}





}
