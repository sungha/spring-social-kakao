package org.springframework.social.kakao.api;


import org.springframework.social.kakao.api.story.StoryOperations;
import org.springframework.social.kakao.api.story.StoryTemplate;
import org.springframework.social.kakao.api.talk.TalkOperations;
import org.springframework.social.kakao.api.talk.TalkTemplate;
import org.springframework.social.kakao.api.user.UserOperations;
import org.springframework.social.kakao.api.user.UserTemplate;


public class KakaoTemplate implements Kakao {

	private UserOperations	userOperations;

	private TalkOperations	talkOperations;

	private StoryOperations	storyOperations;


	public KakaoTemplate(final String accessToken) {
		userOperations = new UserTemplate(accessToken);
		talkOperations = new TalkTemplate(accessToken);
		storyOperations = new StoryTemplate(accessToken);
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

}
