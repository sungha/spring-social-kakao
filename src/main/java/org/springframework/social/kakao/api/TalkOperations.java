package org.springframework.social.kakao.api;


import org.springframework.social.kakao.api.model.KakaoTalkProfile;


/**
 * <pre>
 * 카카오톡 API
 * </pre>
 * 
 * @author sungha
 */
public interface TalkOperations {

	/**
	 * <pre>
	 * 카카오톡 사용자 프로필 요청
	 * https://developers.kakao.com/docs/restapi#카카오톡-프로필-요청
	 * </pre>
	 * 
	 * @return 프로필정보
	 */
	KakaoTalkProfile getProfile();

}
