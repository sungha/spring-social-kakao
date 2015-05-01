package org.springframework.social.kakao.api;


import java.io.File;
import java.util.List;

import org.springframework.social.kakao.api.model.KakaoStoryPost;
import org.springframework.social.kakao.api.model.KakaoStoryProfile;
import org.springframework.social.kakao.api.model.StoryPostOptions;


/**
 * <pre>
 * 카카오스토리 API
 * </pre>
 * 
 * @author sungha
 */
public interface StoryOperations {

	/**
	 * <pre>
	 * 카카오스토리 프로필 가져오기 (secureResource가 true인 경우 https)
	 * https://developers.kakao.com/docs/restapi/tool#collapse_story_0
	 * </pre>
	 * @param secureResource 이미지 URL을 http 또는 https로 받을 것인지 결정하는 파라미터. https로 하고 싶을 경우에 true. 기본값 false
	 * @return 카카오스토리 프로필 정보
	 */
	KakaoStoryProfile getProfile();

	/**
	 * <pre>
	 * 카카오스토리 사용자인지 여부 확인
	 * https://developers.kakao.com/docs/restapi/tool#collapse_story_1
	 * </pre>
	 * @return 카카오스토리 사용중이면 true 아니면 false
	 */
	boolean isStoryUser();

	
	/**
	 * <pre>
	 * 카카오스토리 복수개의 내스토리 정보 요청
	 * https://developers.kakao.com/docs/restapi/tool#collapse_story_2
	 * </pre>
	 * 
	 * @param lastId (옵션) last activity id(excluded, 해당 id는 포함되지 않고 나머지 18개 정도 반환됨), 없을시 최신 18개 정도 반환
	 * @return 카카오스토리 포스팅 목록
	 */
	List<KakaoStoryPost> myStories(final String lastId);
	
	/**
	 * <pre>
	 * 카카오스토리 하나의 내스토리 정보 요청
	 * https://developers.kakao.com/docs/restapi/tool#collapse_story_3
	 * </pre>
	 * 
	 * @param id (필수) activity id
	 * @return 카카오스토리 포스팅 목록
	 */
	KakaoStoryPost myStory(final String id);
	
	/**
	 * <pre>
	 * 내 스토리 삭제
	 * https://developers.kakao.com/docs/restapi#카카오스토리-내스토리-삭제
	 * </pre>
	 * 
	 * @param id (필수) 삭제할 내 스토리 아이디
	 */
	void deleteMyStory(final String id);
	
	
	
	
	
	/**
	 * <pre>
	 * 글 작성
	 * </pre>
	 * 
	 * @param content
	 *            글 내용
	 * @param permission
	 *            공개 범위
	 * @return 작성된 글의 ID
	 */
	String postNote(StoryPostOptions options, String content);

	/**
	 * <pre>
	 * 사진 올리기
	 * </pre>
	 * 
	 * @param content
	 *            글 내용
	 * @param permission
	 *            공개 범위
	 * @param files
	 *            올릴 사진
	 * @return 작성된 글의 ID
	 */
	String postPhoto(StoryPostOptions options, String content, File... files);

	/**
	 * <pre>
	 * 링크 포스팅
	 * </pre>
	 * 
	 * @param content
	 *            글 내용
	 * @param permission
	 *            공개 범위
	 * @return 작성된 글의 ID
	 */
	String postLink(StoryPostOptions options, String content, String url);


}
