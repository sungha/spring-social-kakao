package org.springframework.social.kakao.api.impl;

import org.springframework.social.kakao.api.StoryOperations;
import org.springframework.social.kakao.api.model.KakaoStoryProfile;




public final class StoryTemplate extends AbstractKakaoOperations implements StoryOperations {

	public StoryTemplate(final String accessToken) {
		super(accessToken);
	}


	@Override
	public KakaoStoryProfile getProfile() {
		return getRestTemplate().getForObject(buildUri("/v1/api/story/profile"), KakaoStoryProfile.class);
	}


	@Override
	public void upload() {
		// TODO Auto-generated method stub

	}


	@Override
	public void post() {
		// TODO Auto-generated method stub

	}




}
