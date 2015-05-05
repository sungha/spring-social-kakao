package org.springframework.social.kakao.connect;



import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.api.model.KakaoStoryProfile;
import org.springframework.social.kakao.api.model.KakaoTalkProfile;
import org.springframework.social.kakao.api.model.KakaoUserProfile;


public class KakaoAdapter implements ApiAdapter<Kakao> {

	@Override
	public boolean test(final Kakao api) {
		return api.isAuthorized();
	}

	@Override
	public void setConnectionValues(final Kakao api, final ConnectionValues values) {
		KakaoUserProfile userProfile = api.userOperations().getProfile();
		KakaoTalkProfile talkProfile = api.talkOperations().getProfile();
		KakaoStoryProfile storyProfile = api.storyOperations().getProfile();
		
		values.setProviderUserId(Integer.toString(userProfile.getId()));
		values.setDisplayName(talkProfile.getNickname());

		values.setImageUrl(talkProfile.getProfile());
		values.setProfileUrl(storyProfile.getPermalink());
	}


	@Override
	public UserProfile fetchUserProfile(final Kakao api) {
		KakaoTalkProfile talkProfile = api.talkOperations().getProfile();

		//@formatter:off
		return
				new UserProfileBuilder()
					.setName(talkProfile.getNickname())
					.setUsername(talkProfile.getNickname())
					.build();
		//@formatter:on
	}

	@Override
	public void updateStatus(final Kakao api, final String message) {
		// TODO Auto-generated method stub

	}

}
