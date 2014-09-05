package org.springframework.social.kakao.test.config;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
public class WebAppContext extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment							env;

	
	@Override
	public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> resolvers) {
//		resolvers.add(new AuthenticationPrincipalArgumentResolver());
	}

	

}
