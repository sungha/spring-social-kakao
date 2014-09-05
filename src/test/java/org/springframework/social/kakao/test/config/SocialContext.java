package org.springframework.social.kakao.test.config;


import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.connect.KakaoConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;


@Configuration
@EnableSocial
//@Slf4j
public class SocialContext implements SocialConfigurer {


	@Override
	public void addConnectionFactories(final ConnectionFactoryConfigurer configurer, final Environment env) {
//		String appId = env.getRequiredProperty("social.kakao.appId");
		String appId = UUID.randomUUID().toString().replaceAll("-", "");
		
		configurer.addConnectionFactory(new KakaoConnectionFactory(appId));
	}


	@Override
	public UserIdSource getUserIdSource() {
		return new AuthenticationNameUserIdSource();
	}


	@Override
	public UsersConnectionRepository getUsersConnectionRepository(final ConnectionFactoryLocator connectionFactoryLocator) {
		final InMemoryUsersConnectionRepository usersConnectionRepository = new InMemoryUsersConnectionRepository(connectionFactoryLocator);

//		usersConnectionRepository.setConnectionSignUp(connectionSignUp);

		return usersConnectionRepository;
	}

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public Kakao kakao(final ConnectionRepository repository) {
		final Connection<Kakao> connection = repository.findPrimaryConnection(Kakao.class);
		return connection != null ? connection.getApi() : null;
	}

	@Bean
	public ProviderSignInController providerSignInController(final ConnectionFactoryLocator connectionFactoryLocator, final UsersConnectionRepository usersConnectionRepository) {
		final ProviderSignInController controller = new ProviderSignInController(connectionFactoryLocator, usersConnectionRepository, new CustomSignInAdapter());

//		controller.addSignInInterceptor(new AbstractSigninInterceptor<Kakao>());

		return controller;
	}



}
