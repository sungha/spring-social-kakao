package org.springframework.social.kakao.api.impl;


import static org.fest.assertions.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

import java.net.MalformedURLException;
import java.net.URL;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.api.model.KakaoStoryProfile;
import org.springframework.test.web.client.MockRestServiceServer;


@RunWith(JUnit4.class)
@Slf4j
public class StoryTemplateTest {

	@Test
	public void testGetUserProfile() throws MalformedURLException {
		final Kakao kakao = new KakaoTemplate("");
		final MockRestServiceServer server = MockRestServiceServer.createServer(((StoryTemplate) kakao.storyOperations()).getRestTemplate());

		//@formatter:off
		server
		.expect(requestTo("https://kapi.kakao.com/v1/api/story/profile"))
		.andExpect(method(HttpMethod.GET))
		.andRespond(withSuccess("{\"nickName\":\"홍길동\",\"profileImageURL\":\"http://xxx.kakao.com/.../aaa.jpg\",\"thumbnailURL\":\"http://xxx.kakao.com/.../bbb.jpg\",\"bgImageURL\":\"http://xxx.kakao.com/.../ccc.jpg\",\"birthday\":\"1231\",\"birthdayType\":\"SOLAR\"}", MediaType.APPLICATION_JSON));
		//@formatter:on

		final KakaoStoryProfile profile = kakao.storyOperations().getProfile();



		server.verify();

		log.debug("{}", profile);

		assertThat(profile.getNickname()).isEqualTo("홍길동");
		assertThat(profile.getProfile()).isEqualTo(new URL("http://xxx.kakao.com/.../aaa.jpg"));
		assertThat(profile.getThumbnail()).isEqualTo(new URL("http://xxx.kakao.com/.../bbb.jpg"));
		assertThat(profile.getBackground()).isEqualTo(new URL("http://xxx.kakao.com/.../ccc.jpg"));
		assertThat(profile.getBirthday()).isEqualTo("1231");
		assertThat(profile.getBirthdayType()).isEqualTo(KakaoStoryProfile.BirthdayType.SOLAR);
	}

}
