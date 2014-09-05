package org.springframework.social.kakao.test.config;


import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;


//@Slf4j
public class CustomSignInAdapter implements SignInAdapter {

	@Override
	public String signIn(final String username, final Connection<?> connection, final NativeWebRequest req) {
//		User user = userRepository.findOne(QUser.user.username.eq(username));
//		
//		log.debug("{} {}", username, user);
//
//		Authentication auth = new SocialAuthenticationToken(connection, user, null, user.getAuthorities());
//		SecurityContextHolder.getContext().setAuthentication(auth);
//
//		return (String) req.getAttribute("referer", RequestAttributes.SCOPE_SESSION);
		
		return null;
	}
}
