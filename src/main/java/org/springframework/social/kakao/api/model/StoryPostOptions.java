package org.springframework.social.kakao.api.model;


import lombok.Data;
import lombok.Getter;


@Data
public class StoryPostOptions {

	@Getter
	public static enum Permission {

		PUBLIC("A"), PRIVATE("M"), FRIEND_VISIBLE("F"), FRIEND_SHAREABLE("F");

		private String	value;

		Permission(String value) {
			this.value = value;
		}
	}

	
	private Permission	permission;


//	private String		android_exec_param;
//
//	private String		android_market_param;
//
//	private String		ios_exec_param;
//
//	private String		ios_market_param;



	public StoryPostOptions() {
		this.permission = Permission.PUBLIC;
	}


	public StoryPostOptions(Permission permission) {
		this.permission = permission;
	}



}
