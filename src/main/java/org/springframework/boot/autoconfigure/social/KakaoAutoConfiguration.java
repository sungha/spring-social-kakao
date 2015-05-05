package org.springframework.boot.autoconfigure.social;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.GenericConnectionStatusView;
import org.springframework.social.kakao.api.Kakao;
import org.springframework.social.kakao.api.impl.KakaoTemplate;
import org.springframework.social.kakao.connect.KakaoConnectionFactory;
import org.springframework.web.servlet.View;


@Configuration
@ConditionalOnClass({ SocialConfigurerAdapter.class, KakaoConnectionFactory.class })
@ConditionalOnProperty(prefix = "spring.social.kakao", name = "appId")
@AutoConfigureBefore(SocialWebAutoConfiguration.class)
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
public class KakaoAutoConfiguration {

	@Configuration
	@EnableSocial
	@EnableConfigurationProperties(KakaoProperties.class)
	@ConditionalOnWebApplication
	protected static class KakaoConfigurerAdapter extends SocialConfigurerAdapter {

		@Autowired
		private KakaoProperties	properties;

		@Bean
		@ConditionalOnMissingBean(Kakao.class)
		@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
		public Kakao kakao(ConnectionRepository repository) {
			Connection<Kakao> connection = repository.findPrimaryConnection(Kakao.class);
			return connection != null ? connection.getApi() : new KakaoTemplate();
		}

		@Bean(name = { "connect/kakaoConnect", "connect/kakaoConnected" })
		@ConditionalOnProperty(prefix = "spring.social", name = "auto-connection-views")
		public View kakaoConnectView() {
			return new GenericConnectionStatusView("kakao", "Kakao");
		}

		@Override
		public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
			ConnectionFactory<?> kakaoConnectionFactory = new KakaoConnectionFactory(this.properties.getAppId());
			connectionFactoryConfigurer.addConnectionFactory(kakaoConnectionFactory);
		}

	}

}
