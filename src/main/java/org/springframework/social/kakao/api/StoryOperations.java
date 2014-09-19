package org.springframework.social.kakao.api;


import java.io.File;

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
	 * 카카오스토리 프로필 가져오기
	 * </pre>
	 * 
	 * @return
	 */
	KakaoStoryProfile getProfile();

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
