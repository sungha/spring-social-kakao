package org.springframework.social.kakao.api.impl;


import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;




public abstract class AbstractKakaoOperations extends AbstractOAuth2ApiBinding {

	private static final String	API_HOST	= "https://kapi.kakao.com";


	public AbstractKakaoOperations(final String accessToken) {
		super(accessToken);
	}


	String buildUri(String uri) {
		return API_HOST + uri;
	}

}
