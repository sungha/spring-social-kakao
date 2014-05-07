package kr.steelheart.user.provider.kakao.api;


import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;




public abstract class AbstractKakaoOperations extends AbstractOAuth2ApiBinding {

	protected static final String	API_HOST	= "https://kapi.kakao.com";


	public AbstractKakaoOperations(final String accessToken) {
		super(accessToken);
	}

}
