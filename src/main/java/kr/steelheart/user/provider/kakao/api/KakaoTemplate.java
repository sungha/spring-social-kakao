package kr.steelheart.user.provider.kakao.api;



import kr.steelheart.user.provider.kakao.api.talk.KakaoTalkOperations;
import kr.steelheart.user.provider.kakao.api.talk.KakaoTalkTemplate;

import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;


public class KakaoTemplate extends AbstractOAuth2ApiBinding implements Kakao {

	private KakaoTalkOperations	kakaoTalkOperations;


	public KakaoTemplate(final String accessToken) {
		super(accessToken);
		kakaoTalkOperations = new KakaoTalkTemplate(accessToken);
	}


	@Override
	public KakaoTalkOperations kakaoTalkOperations() {
		return kakaoTalkOperations;
	}


}
