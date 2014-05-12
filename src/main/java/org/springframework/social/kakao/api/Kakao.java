package org.springframework.social.kakao.api;


import org.springframework.social.kakao.api.story.StoryOperations;
import org.springframework.social.kakao.api.talk.TalkOperations;
import org.springframework.social.kakao.api.user.UserOperations;


public interface Kakao {

	UserOperations userOperations();

	TalkOperations talkOperations();

	StoryOperations storyOperations();

}
