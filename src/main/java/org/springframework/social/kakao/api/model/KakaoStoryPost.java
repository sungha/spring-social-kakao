package org.springframework.social.kakao.api.model;


import java.util.Date;
import java.util.List;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 카카오스토리 글
 * 
 * @author sungha
 */
@Data
public class KakaoStoryPost {

	public static enum MediaType {
		NOTE, PHOTO, NOT_SUPPORTED;
	}

	public static enum Permission {
		PUBLIC, FRIEND, ONLY_ME;
	}


	/** 포스팅 결과로 받는 스토리별 고유 아이디 */
	@JsonProperty("id")
	private String			id;

	/** 해당 내스토리로 갈 수 있는 web url */
	@JsonProperty("url")
	private String			url;

	/** 스토리 타입 */
	@JsonProperty("media_type")
	private MediaType		mediaType;

	/** media_type이 PHOTO 스토리인 경우, 크기별로 이미지 URL로 구성된 객체의 array */
	@JsonProperty("media")
	private List<Media>		media;

	/** 스토리 생성시각 RFC3339 */
	@JsonProperty("created_at")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
	private Date			created;

	/** 스토리 구성중 텍스트에 해당하는 글 내용 */
	@JsonProperty("content")
	private String			content;

	/** 댓글수 */
	@JsonProperty("comment_count")
	private String			commentCount;

	/** 댓글 내용과 댓글 작성자. 하나의 내스토리 정보 요청인 경우만 제공 */
	@JsonProperty("comments")
	private List<Comment>	comments;

	/** 느낌수 */
	@JsonProperty("like_count")
	private String			likeCount;

	/** 느낌 내용과 느낌 작성자. 하나의 내스토리 정보 요청인 경우만 제공 */
	@JsonProperty("likes")
	private List<Like>		likes;

	/** 스토리 공개 범위 */
	@JsonProperty("permission")
	private Permission		permission;


}
