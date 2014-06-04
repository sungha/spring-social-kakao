package org.springframework.social.kakao.api.impl;

import static org.fest.assertions.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.api.model.KakaoUserProfile;
import org.springframework.test.web.client.MockRestServiceServer;


@RunWith(JUnit4.class)
@Slf4j
public class UserTemplateTest {
	
	@Test
	public void testGetUserProfile() {
		Kakao kakao = new KakaoTemplate("");
		MockRestServiceServer server = MockRestServiceServer.createServer(((UserTemplate) kakao.userOperations()).getRestTemplate());
		
		//@formatter:off
		server
			.expect(requestTo("https://kapi.kakao.com/v1/user/me"))
			.andExpect(method(HttpMethod.GET))
			.andRespond(withSuccess("{ \"id\": 111, \"properties\": { \"nickname\": \"John Doe\"}}", MediaType.APPLICATION_JSON));
		//@formatter:on
		
		KakaoUserProfile profile = kakao.userOperations().getProfile();
		
		server.verify();
		
		log.debug("{}", profile);
		
		assertThat(profile.getId()).isEqualTo(111);
		assertThat(profile.getNickname()).isEqualTo("John Doe");
		assertThat(profile.getProfile()).isNull();
		assertThat(profile.getThumbnail()).isNull();
	}

}
