package org.springframework.social.kakao.web;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;


/**
 * <pre>
 * 카카오 API 정책상 URI가 항상 /oauth로 끝나고 몇몇 파라메터가 추가되어야 하는 제한 회피용
 * </pre>
 * 
 * @author steelheart
 */
@Controller
public class KakaoSigninController {

	private final String	domain;
	private final String	clientId;


	public KakaoSigninController(final String domain, final String clientId) {
		this.domain = domain;
		this.clientId = clientId;
	}


	@RequestMapping(value = "/oauth")
	public RedirectView redirect(final HttpServletRequest request) {
		StringBuilder url = new StringBuilder("/signin/kakao?");

		url.append(request.getQueryString());
		url.append("&grant_type=authorization_code");
		url.append("&client_id=").append(clientId);
		url.append("&redirect_uri=").append(domain).append("/oauth");

		return new RedirectView(url.toString());
	}

}
