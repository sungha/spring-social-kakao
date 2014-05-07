package kr.steelheart.user.provider.kakao.web;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;


public class KakaoConnectController {

	private final String	domain;
	private final String	clientId;


	public KakaoConnectController(final String domain, final String clientId) {
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
