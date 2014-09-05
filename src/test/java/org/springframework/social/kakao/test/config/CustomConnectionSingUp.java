package org.springframework.social.kakao.test.config;


import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;


//@Slf4j
public class CustomConnectionSingUp implements ConnectionSignUp {

	@Override
	public String execute(final Connection<?> connection) {
//		User user = new User();
//
//		user = userRepository.findOne(QUser.user.username.eq(connection.getKey().toString()));
//
//		if (user == null) {
//			user = new User();
//			updateUserFromConnection(connection, user);
//			userRepository.save(user);
//		}
//		else {
//			updateUserFromConnection(connection, user);
//		}
//
//		return user.getUsername();
		
		return null;
	}

}
