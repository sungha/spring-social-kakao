package org.springframework.social.kakao.api.talk;


import org.springframework.social.kakao.api.AbstractKakaoOperations;


public final class TalkTemplate extends AbstractKakaoOperations implements TalkOperations {

	private static final String	PROFILE_REQUEST_URL	= API_HOST + "/v1/api/talk/profile";


	public TalkTemplate(final String accessToken) {
		super(accessToken);
	}


	@Override
	public KakaoTalkProfile getProfile() {
		return getRestTemplate().getForObject(PROFILE_REQUEST_URL, KakaoTalkProfile.class);
	}


}
