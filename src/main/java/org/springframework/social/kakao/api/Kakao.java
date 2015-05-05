package org.springframework.social.kakao.api;

import org.springframework.social.ApiBinding;




/**
 * <pre>
 * Kakao REST API
 * </pre>
 * 
 * @author sungha
 */
public interface Kakao extends ApiBinding {

	String	PROVIDER_ID	= "kakao";


	/**
	 * 카카오 사용자 API
	 * 
	 * @return
	 */
	UserOperations userOperations();

	/**
	 * 카카오톡 API
	 * 
	 * @return
	 */
	TalkOperations talkOperations();

	/**
	 * 카카오스토리 API
	 * 
	 * @return
	 */
	StoryOperations storyOperations();

	/**
	 * 푸쉬알림 API
	 * 
	 * @return
	 */
	PushOperations pushOperations();


}
