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
import org.springframework.social.kakao.api.model.KakaoTalkProfile;
import org.springframework.test.web.client.MockRestServiceServer;


@RunWith(JUnit4.class)
@Slf4j
public class TalkTemplateTest {
	
	@Test
	public void testGetUserProfile() throws MalformedURLException {
		Kakao kakao = new KakaoTemplate("");
		MockRestServiceServer server = MockRestServiceServer.createServer(((TalkTemplate) kakao.talkOperations()).getRestTemplate());
		
		//@formatter:off
		server
			.expect(requestTo("https://kapi.kakao.com/v1/api/talk/profile"))
			.andExpect(method(HttpMethod.GET))
			.andRespond(withSuccess("{ \"nickName\": \"John Doe\", \"profileImageURL\": \"http://xxx.kakao.com/.../aaa.jpg\", \"thumbnailURL\": \"http://xxx.kakao.com/.../bbb.jpg\"}", MediaType.APPLICATION_JSON));
		//@formatter:on
		
		KakaoTalkProfile profile = kakao.talkOperations().getProfile();
		
		server.verify();
		
		log.debug("{}", profile);
		
		assertThat(profile.getNickname()).isEqualTo("John Doe");
		assertThat(profile.getProfile()).isEqualTo(new URL("http://xxx.kakao.com/.../aaa.jpg"));
		assertThat(profile.getThumbnail()).isEqualTo(new URL("http://xxx.kakao.com/.../bbb.jpg"));
		assertThat(profile.getCountry()).isNull();
	}

}
