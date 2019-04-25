package com.gz.pigvideo.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class FeignConfig implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		String authorization = request.getHeader("Authorization");
		if(authorization != null) {
			template.header("Authorization", authorization);
		}
	}
}