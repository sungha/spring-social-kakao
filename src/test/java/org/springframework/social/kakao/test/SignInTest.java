package org.springframework.social.kakao.test;


import static org.fest.assertions.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.kakao.test.config.SocialContext;
import org.springframework.social.kakao.test.config.WebAppContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SocialContext.class, WebAppContext.class })
@WebAppConfiguration("src/test/webapp")
public class SignInTest {

	@Autowired
	private WebApplicationContext	ctx;

	private MockMvc					mvc;


	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		// MockitoAnnotations.initMocks(this);
	}


	@Test
	public void testSignIn() throws Exception {
		MockHttpServletRequestBuilder request = post("/signin/kakao");

		ResultActions actions = mvc.perform(request);
		// actions.andDo(print());
		actions.andExpect(status().is3xxRedirection());

		String redirected = actions.andReturn().getResponse().getRedirectedUrl();

		assertThat(redirected).startsWith("https://kauth.kakao.com/oauth/authorize");
	}
	
	
	@Test
	public void testSignIn2() throws Exception {
		MockHttpServletRequestBuilder request = get("/signin/kakao");
		request.param("access_token", "");
		
		ResultActions actions = mvc.perform(request);
		actions.andDo(print());
		actions.andExpect(status().is3xxRedirection());
		
		String redirected = actions.andReturn().getResponse().getRedirectedUrl();
		
		assertThat(redirected).startsWith("/signin");
	}

}
