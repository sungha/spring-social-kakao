package org.springframework.social.kakao.api.impl;


import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.api.PushOperations;
import org.springframework.social.kakao.api.StoryOperations;
import org.springframework.social.kakao.api.TalkOperations;
import org.springframework.social.kakao.api.UserOperations;


public class KakaoTemplate extends AbstractKakaoOperations implements Kakao {

	private UserOperations	user;
	private TalkOperations	talk;
	private StoryOperations	story;
	private PushOperations	push;

	public KakaoTemplate() {
		super(null);
	}

	public KakaoTemplate(final String accessToken) {
		super(accessToken);

		user = new UserTemplate(accessToken);
		talk = new TalkTemplate(accessToken);
		story = new StoryTemplate(accessToken);
		push = new PushTemplate(accessToken);
	}


	@Override
	public UserOperations userOperations() {
		return user;
	}


	@Override
	public TalkOperations talkOperations() {
		return talk;
	}


	@Override
	public StoryOperations storyOperations() {
		return story;
	}


	@Override
	public PushOperations pushOperations() {
		return push;
	}

}
