package com.gz.pigvideo.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class MyFilter extends ZuulFilter {

	private static final Logger log = LoggerFactory.getLogger(MyFilter.class);
	
	@Override
	public String filterType() {
		return "pre"; // 可以在请求被路由之前调用
	}

	@Override
	public int filterOrder() {
		return 0; // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
	}

	/**
	 * 是否执行该过滤器，此处为true，说明需要过滤
	 */
	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		if (request.getMethod().equals("OPTIONS")) {
			return true;
		}
		//转发Authorization
		ctx.addZuulRequestHeader("Authorization", request.getHeader("Authorization"));
		String origin = request.getHeader("Origin");
		log.info("访问用户IP:" + origin);
		
		return false;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.setSendZuulResponse(true); // 对请求进行路由
		ctx.setResponseStatusCode(200);
		ctx.set("isSuccess", true);
		return null;
	}

}
