package kr.steelheart.user.provider.kakao.connect;


import kr.steelheart.user.provider.kakao.api.Kakao;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;


public class KakaoConnectionFactory extends OAuth2ConnectionFactory<Kakao> {


	public KakaoConnectionFactory(final String domain, final String appId) {
		super("kakao", new KakaoServiceProvider(domain, appId), new KakaoAdapter());
	}



}
