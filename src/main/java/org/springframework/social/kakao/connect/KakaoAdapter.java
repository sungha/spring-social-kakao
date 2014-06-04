package org.springframework.social.kakao.connect;



import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.api.model.KakaoTalkProfile;
import org.springframework.social.kakao.api.model.KakaoUserProfile;


public class KakaoAdapter implements ApiAdapter<Kakao> {

	@Override
	public boolean test(final Kakao api) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setConnectionValues(final Kakao api, final ConnectionValues values) {
		KakaoUserProfile userProfile = api.userOperations().getProfile();
		KakaoTalkProfile talkProfile = api.talkOperations().getProfile();

		values.setProviderUserId(Integer.toString(userProfile.getId()));
		values.setDisplayName(talkProfile.getNickname());

		values.setImageUrl(talkProfile.getProfile().toString());
		values.setProfileUrl(null); // 아직 카카오스토리 웹버전에 대한 링크주소 또는 아이디를 가져오는 API는 없는듯.
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
