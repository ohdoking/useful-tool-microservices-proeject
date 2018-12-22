package com.ohdoking.api.gateway.filter;

import java.util.UUID;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 
 * Route filters run after pre filters and make requests to other services. 
 * Much of the work here is to translate request and response data to and from the model required by the client. 
 * 
 * @author ohdoking
 *
 */
public class RoutingFilter extends ZuulFilter {
	
	private static Logger logger = LoggerFactory.getLogger(RoutingFilter.class);

	
	private static final int SEND_RESPONSE_FILTER_ORDER = 2;

	@Override
	public String filterType() {
		return "routing";
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
    	HttpServletRequest servletRequest = context.getRequest();
		
		logger.info(String.format("[routing]cookie value : %s", servletRequest.getCookies().toString()));
		
		return null;
	}
}