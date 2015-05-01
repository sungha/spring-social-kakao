package org.springframework.social.kakao.api.impl;

import org.junit.After;
import org.junit.Before;
import org.springframework.social.kakao.api.impl.KakaoTemplate;
import org.springframework.social.kakao.connect.KakaoServiceProvider;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;

public abstract class KakaoTest {

	protected KakaoTemplate kakao;

	
	@Before
	public void setup() {
		OAuth2Operations oauth = new KakaoServiceProvider("").getOAuthOperations();
		AccessGrant clientGrant = oauth.authenticateClient();
		kakao = new KakaoTemplate(clientGrant.getAccessToken());
	}
	

	@After
	public void teardown() {
	}

}