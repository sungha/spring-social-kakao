package org.springframework.social.kakao.connect;


import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;


public class KakaoOAuth2Template extends OAuth2Template {

	private static final String	AUTHORIZE_URL		= "https://kauth.kakao.com/oauth/authorize";
	private static final String	ACCESS_TOKEN_URL	= "https://kauth.kakao.com/oauth/token";

	private final String		domain;
	private final String		clientId;


	public KakaoOAuth2Template(final String domain, final String clientId) {
		super(clientId, "", AUTHORIZE_URL, ACCESS_TOKEN_URL);
		setUseParametersForClientAuthentication(true);
		this.domain = domain;
		this.clientId = clientId;
	}


	@Override
	public String buildAuthorizeUrl(final OAuth2Parameters parameters) {
		parameters.setRedirectUri(domain + "/oauth");
		return super.buildAuthorizeUrl(parameters);
	}


	@Override
	public String buildAuthenticateUrl(final OAuth2Parameters parameters) {
		parameters.setRedirectUri(domain + "/oauth");
		parameters.add("grant_type", "authorization_code");
		parameters.add("client_id", clientId);

		return super.buildAuthenticateUrl(parameters);
	}


	@Override
	public String buildAuthorizeUrl(final GrantType grantType, final OAuth2Parameters parameters) {
		parameters.setRedirectUri(domain + "/oauth");

		return super.buildAuthorizeUrl(grantType, parameters);
	}



	@Override
	protected AccessGrant postForAccessGrant(final String accessTokenUrl, final MultiValueMap<String, String> parameters) {
		parameters.set("redirect_uri", domain + "/oauth");

		return super.postForAccessGrant(accessTokenUrl, parameters);
	}

}
