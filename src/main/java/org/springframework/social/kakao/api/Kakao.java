package org.springframework.social.kakao.api;




/**
 * <pre>
 * Kakao REST API
 * </pre>
 * 
 * @author sungha
 */
public interface Kakao {
	
	public static final String PROVIDER_ID = "kakao";
	

	/**
	 * 카카오 사용자 API
	 * @return
	 */
	UserOperations userOperations();

	/**
	 * 카카오톡 API
	 * @return
	 */
	TalkOperations talkOperations();

	/**
	 * 카카오스토리 API
	 * @return
	 */
	StoryOperations storyOperations();
	
	/**
	 * 푸쉬알림 API
	 * @return
	 */
	PushOperations pushOperations();
	

}
