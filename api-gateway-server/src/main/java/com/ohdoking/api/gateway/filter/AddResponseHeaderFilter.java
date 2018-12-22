package com.ohdoking.api.gateway.filter;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 
 * Post filters typically manipulate the response.
 * 
 * @author ohdoking
 *
 */
public class AddResponseHeaderFilter extends ZuulFilter {
	
	private static Logger logger = LoggerFactory.getLogger(AddResponseHeaderFilter.class);

	
	private static final int SEND_RESPONSE_FILTER_ORDER = 3;

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return SEND_RESPONSE_FILTER_ORDER - 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
    	HttpServletResponse servletResponse = context.getResponse();
		servletResponse.addHeader("X-Sample", UUID.randomUUID().toString());
		
		logger.info(String.format("[post]x-sample uuid : %s", UUID.randomUUID().toString()));
		
		return null;
	}
}