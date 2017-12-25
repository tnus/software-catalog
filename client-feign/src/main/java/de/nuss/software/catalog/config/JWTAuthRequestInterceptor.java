package de.nuss.software.catalog.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Can be used to add an authorization header to all requests
 * 
 * @author Thorsten Nuss
 *
 */
public class JWTAuthRequestInterceptor implements RequestInterceptor {
	@Override
	public void apply(RequestTemplate template) {
		template.header("X-Forwarded-For", "origin.host.com");
	}

}
