package com.ohdoking.api.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 
 * Pre filters set up data in the RequestContext for use in filters downstream. 
 * The main use case is to set information required for route filters.
 * 
 * @author ohdoking
 *
 */
public class SimpleFilter extends ZuulFilter {
	private static Logger logger = LoggerFactory.getLogger(SimpleFilter.class);

	@Override
	public String filterType() {
		return "pre";
	} // "post", "routing", "error"

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		logger.info(String.format("[pre]%s request to %s", request.getMethod(), request.getRequestURL().toString()));

		return null;
	}
}