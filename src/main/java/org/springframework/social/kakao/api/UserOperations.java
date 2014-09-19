package org.springframework.social.kakao.api;


import org.springframework.social.kakao.api.model.KakaoUserProfile;



/**
 * <pre>
 * 카카오 사용자 API
 * </pre>
 * 
 * @author sungha
 */
public interface UserOperations {

	KakaoUserProfile getProfile();


}
