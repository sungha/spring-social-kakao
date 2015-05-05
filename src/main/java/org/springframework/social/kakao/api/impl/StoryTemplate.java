package org.springframework.social.kakao.api.impl;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.social.kakao.api.StoryOperations;
import org.springframework.social.kakao.api.model.KakaoStoryPost;
import org.springframework.social.kakao.api.model.KakaoStoryProfile;
import org.springframework.social.kakao.api.model.StoryPostOptions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;




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
		final List<String> uploaded = upload(files);

		final String postedId = post(content, uploaded, options);
		
		return postedId;
	}
	

//	array of like this: "/aaaaa/bBbbbBbbbB/CCcCcC1ccCCcCCCCCCcc1c/img.png?width=150&height=150"
	private List<String> upload(File... files) {
		RestTemplate template = getRestTemplate();

		LinkedMultiValueMap<String, Object> request = new LinkedMultiValueMap<>();
		
		assert files != null && files.length <= 5;
		for (File file: files) {
			request.add("file", new FileSystemResource(file));
		}
		
		String uri = buildUri("/v1/api/story/upload/multi");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<LinkedMultiValueMap<String, Object>>(request, headers);

		ResponseEntity<List<String>> result = template.exchange(uri, HttpMethod.POST, entity, new ParameterizedTypeReference<List<String>>() {
		});

		return result.getBody();
	}
	
	
	private String post(final String content, final List<String> files, StoryPostOptions options) {
		RestTemplate template = getRestTemplate();

		MultiValueMap<String, Object> request = new LinkedMultiValueMap<String, Object>();
		
		assert files != null && files.size() <= 5;
		request.add("image_url_list", files); // TODO json
		
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



	@Override
	public boolean isStoryUser() {
		@SuppressWarnings("unchecked")
		final Map<String, Boolean> result = getRestTemplate().getForObject(buildUri("/v1/api/story/isstoryuser"), HashMap.class);
		final Boolean re = (Boolean) result.get("isStoryUser");

		if (re != null) {
			return re.booleanValue();
		}

		return false;
	}



	@Override
	public List<KakaoStoryPost> myStories(String lastId) {
		final RestTemplate template = getRestTemplate();
		final String url = buildUri("/v1/api/story/mystories");

		ResponseEntity<List<KakaoStoryPost>> result = template.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<KakaoStoryPost>>() {
		});

		return result.getBody();
	}



	@Override
	public KakaoStoryPost myStory(String id) {
		final RestTemplate template = getRestTemplate();
		final String url = buildUri("/v1/api/story/mystory");

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("id", id);


		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		HttpEntity<?> entity = new HttpEntity<>(null, headers);

		ResponseEntity<KakaoStoryPost> result = template.exchange(builder.build().toUri(), HttpMethod.GET, entity, new ParameterizedTypeReference<KakaoStoryPost>() {
		});

		return result.getBody();
	}



	@Override
	public void deleteMyStory(String id) {
		// TODO Auto-generated method stub

	}


	public static void main(String[] args) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.kakao.com");
		
		builder.path("/v1/api");
		builder.path("/story");
		builder.path("/mystory");
		
		builder.queryParam("id", "AAAA.BBBBB");
		
		System.out.println(builder.build().toUri());
		
	}


}



