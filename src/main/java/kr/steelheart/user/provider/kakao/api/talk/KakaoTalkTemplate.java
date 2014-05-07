package kr.steelheart.user.provider.kakao.api.talk;


import kr.steelheart.user.provider.kakao.api.AbstractKakaoOperations;
import kr.steelheart.user.provider.kakao.api.talk.model.KakaoTalkProfile;


public class KakaoTalkTemplate extends AbstractKakaoOperations implements KakaoTalkOperations {

	private static final String	PROFILE_REQUEST_URL	= API_HOST + "/v1/api/talk/profile";


	public KakaoTalkTemplate(final String accessToken) {
		super(accessToken);
	}


	@Override
	public KakaoTalkProfile getProfile() {
		return getRestTemplate().getForObject(PROFILE_REQUEST_URL, KakaoTalkProfile.class);
	}


}
