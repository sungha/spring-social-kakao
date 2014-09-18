package org.springframework.social.kakao.api.impl;


import java.io.File;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.social.kakao.api.StoryOperations;
import org.springframework.social.kakao.api.model.KakaoStoryProfile;
import org.springframework.social.kakao.api.model.StoryPostOptions;
import org.springframework.social.kakao.api.model.StoryPostOptions.Permission;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;




public final class StoryTemplate extends AbstractKakaoOperations implements StoryOperations {

	public StoryTemplate(final String accessToken) {
		super(accessToken);
	}


	@Override
	public KakaoStoryProfile getProfile() {
		return getRestTemplate().getForObject(buildUri("/v1/api/story/profile"), KakaoStoryProfile.class);
	}


	@Override
	public String postNote(StoryPostOptions options, String content) {
		RestTemplate template = getRestTemplate();
		
		MultiValueMap<String, Object> request = new LinkedMultiValueMap<String, Object>();
		request.set("content", content);
		request.set("permission", options.getPermission().getValue());
		request.set("", "");

		String uri = buildUri("/v1/api/story/post/note");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		HttpEntity<?> entity = new HttpEntity<MultiValueMap<String, Object>>(request, headers);

		ResponseEntity<Map<String, Object>> result = template.exchange(uri, HttpMethod.POST, entity, new ParameterizedTypeReference<Map<String, Object>>() {
		});

		return (String) result.getBody().get("id");
	}


	@Override
	public String postPhoto(StoryPostOptions options, String content, File... files) {
		RestTemplate template = getRestTemplate();
		
		MultiValueMap<String, Object> request = new LinkedMultiValueMap<String, Object>();
		request.set("content", content);
		request.set("permission", options.getPermission().getValue());

		String uri = buildUri("/v1/api/story/post/photo");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		HttpEntity<?> entity = new HttpEntity<MultiValueMap<String, Object>>(request, headers);

		ResponseEntity<Map<String, Object>> result = template.exchange(uri, HttpMethod.POST, entity, new ParameterizedTypeReference<Map<String, Object>>() {
		});

		return (String) result.getBody().get("id");
	}

	
	@Override
	public String postLink(StoryPostOptions options, String content, String url) {
		RestTemplate template = getRestTemplate();
		
		MultiValueMap<String, Object> request = new LinkedMultiValueMap<String, Object>();
		request.set("content", content);
		request.set("permission", options.getPermission().getValue());
		
		String uri = buildUri("/v1/api/story/post/link");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		HttpEntity<?> entity = new HttpEntity<MultiValueMap<String, Object>>(request, headers);
		
		ResponseEntity<Map<String, Object>> result = template.exchange(uri, HttpMethod.POST, entity, new ParameterizedTypeReference<Map<String, Object>>() {
		});
		
		return (String) result.getBody().get("id");
	}
	



}
