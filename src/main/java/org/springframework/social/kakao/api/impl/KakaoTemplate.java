package org.springframework.social.kakao.api.impl;


import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.api.PushOperations;
import org.springframework.social.kakao.api.StoryOperations;
import org.springframework.social.kakao.api.TalkOperations;
import org.springframework.social.kakao.api.UserOperations;


public class KakaoTemplate implements Kakao {

	private UserOperations	userOperations;

	private TalkOperations	talkOperations;

	private StoryOperations	storyOperations;
	
	private PushOperations	pushOperations;


	public KakaoTemplate(final String accessToken) {
		userOperations = new UserTemplate(accessToken);
		talkOperations = new TalkTemplate(accessToken);
		storyOperations = new StoryTemplate(accessToken);
		pushOperations = new PushTemplate(accessToken);
	}


	@Override
	public UserOperations userOperations() {
		return userOperations;
	}


	@Override
	public TalkOperations talkOperations() {
		return talkOperations;
	}


	@Override
	public StoryOperations storyOperations() {
		return storyOperations;
	}
	
	
	@Override
	public PushOperations pushOperations() {
		return pushOperations;
	}

}
