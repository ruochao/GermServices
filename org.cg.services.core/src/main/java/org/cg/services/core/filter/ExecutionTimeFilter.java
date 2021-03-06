package org.cg.services.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * A HTTP filter utilized to log request execution time
 * @author WZ
 *
 */
public class ExecutionTimeFilter extends OncePerRequestFilter implements Filter { 

	private static final Log LOG = LogFactory.getLog(ExecutionTimeFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
			throws ServletException, IOException {

		long start = System.currentTimeMillis();   
		filterChain.doFilter(request, response);
		long elapsedTime = System.currentTimeMillis() - start;
		LOG.info("Request execution time: " + elapsedTime + " ms.");
	}
}
