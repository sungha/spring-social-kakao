package org.springframework.social.kakao.connect;



import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.kakao.api.Kakao;


public class KakaoConnectionFactory extends OAuth2ConnectionFactory<Kakao> {


	public KakaoConnectionFactory(final String appId) {
		super(Kakao.PROVIDER_ID, new KakaoServiceProvider(appId), new KakaoAdapter());
	}



}
