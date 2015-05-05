package org.springframework.social.kakao.connect;


import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.social.oauth2.OAuth2Template;


public class KakaoOAuth2Template extends OAuth2Template {

	private static final String	AUTHORIZE_URL		= "https://kauth.kakao.com/oauth/authorize";
	private static final String	ACCESS_TOKEN_URL	= "https://kauth.kakao.com/oauth/token";

	
	public KakaoOAuth2Template(final String appId) {
		super(appId, "", AUTHORIZE_URL, ACCESS_TOKEN_URL);
		setUseParametersForClientAuthentication(true);
	}

	
	@Override
	public String buildAuthenticateUrl(final OAuth2Parameters parameters) {
		parameters.add("grant_type", "authorization_code");

		return super.buildAuthenticateUrl(parameters);
	}


}
