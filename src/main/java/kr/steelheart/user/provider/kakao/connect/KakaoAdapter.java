package kr.steelheart.user.provider.kakao.connect;


import kr.steelheart.user.provider.kakao.api.Kakao;
import kr.steelheart.user.provider.kakao.api.talk.model.KakaoTalkProfile;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;


public class KakaoAdapter implements ApiAdapter<Kakao> {

	@Override
	public boolean test(final Kakao api) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setConnectionValues(final Kakao api, final ConnectionValues values) {
		KakaoTalkProfile profile = api.kakaoTalkOperations().getProfile();

		values.setDisplayName(profile.getNickname());
		values.setImageUrl(profile.getThumbnail());
		values.setProfileUrl(profile.getProfile());
		values.setProviderUserId(Integer.toString(profile.getProfile().hashCode()));
	}


	@Override
	public UserProfile fetchUserProfile(final Kakao api) {
		KakaoTalkProfile profile = api.kakaoTalkOperations().getProfile();

		//@formatter:off
		return
				new UserProfileBuilder()
					.setName(profile.getNickname())
					.setUsername(profile.getNickname())
					.build();
		//@formatter:on
	}

	@Override
	public void updateStatus(final Kakao api, final String message) {
		// TODO Auto-generated method stub

	}

}
