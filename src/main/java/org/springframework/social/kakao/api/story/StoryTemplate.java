package org.springframework.social.kakao.api.story;


import org.springframework.social.kakao.api.AbstractKakaoOperations;


public final class StoryTemplate extends AbstractKakaoOperations implements StoryOperations {

	private static final String	PROFILE_REQUEST_URL	= API_HOST + "/v1/api/story/profile";


	public StoryTemplate(final String accessToken) {
		super(accessToken);
	}


	@Override
	public void getProfile() {
		// TODO Auto-generated method stub

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
