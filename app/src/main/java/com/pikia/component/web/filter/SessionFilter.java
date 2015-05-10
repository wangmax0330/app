package com.pikia.component.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

public class SessionFilter implements Filter {
	protected final Logger logger = Logger.getLogger(SessionFilter.class);
	public static final String IGNORE_URLS = "ignoreUrls";
	protected FilterConfig filterConfig;
	protected String[] ignoreUrls;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		if (this.logger.isInfoEnabled()) {
			this.logger.info("Initializing filter '"
					+ filterConfig.getFilterName() + "'");
		}
		this.filterConfig = filterConfig;
		String ignoreUrlsString = this.filterConfig
				.getInitParameter("ignoreUrls");
		if (StringUtils.hasText(ignoreUrlsString)) {
			if (this.logger.isInfoEnabled()) {
				this.logger.info("Ignore Urls: " + ignoreUrlsString);
			}
			this.ignoreUrls = StringUtils
					.commaDelimitedListToStringArray(ignoreUrlsString);
		} else {
			if (this.logger.isInfoEnabled()) {
				this.logger.info("No ignore list configured");
			}
			this.ignoreUrls = new String[0];
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		// SessionService sessionService =
		// (SessionService)SpringContextHolder.getApplicationContext().getBean(SessionService.class);
		String requestUrl = httpRequest.getRequestURL().toString();
		// httpRequest.setAttribute("login_old_path", requestUrl);
		if (ignoreRequest(httpRequest)) {
			filterChain.doFilter(request, response);
		} else {
			// Object user =
			// sessionService.getCurrentUser(httpRequest.getSession(),
			// Object.class);
			// if(true)
			// if (isAjax(httpRequest)) {
			// redirect("/d/page/res.ajaxSessionOut", httpRequest,
			// (HttpServletResponse)response);
			// }
			// } else {
			// String requestUrl = httpRequest.getRequestURL().toString();
			// httpRequest.setAttribute("login_old_path", requestUrl);
			//
			// request.getRequestDispatcher("/d/page/index").forward(request, response);
			// }
			// } else {
			// }
			 filterChain.doFilter(request, response);
			// }
		}
	}

	protected boolean ignoreRequest(HttpServletRequest httpRequest) {
		String requestUrl = httpRequest.getRequestURL().toString();
		if (this.logger.isDebugEnabled()) {
			this.logger.debug("Request URL: " + requestUrl);
		}
		String context = httpRequest.getContextPath();
		for (String ignoreUrl : this.ignoreUrls) {
			if (requestUrl.indexOf(context + ignoreUrl) > -1) {
				if (this.logger.isDebugEnabled()) {
					this.logger.debug("Matched ignore url: " + ignoreUrl
							+ ", passing......");
				}
				return true;
			}
		}
		return false;
	}

	protected boolean isAjax(HttpServletRequest httpRequest) {
		String requestUrl = httpRequest.getRequestURL().toString();
		if (this.logger.isDebugEnabled()) {
			this.logger.debug("Request URL: " + requestUrl);
		}
		requestUrl = requestUrl.substring(requestUrl.indexOf(":") + 3);
		requestUrl = requestUrl.substring(requestUrl.indexOf("/"));
		String context = httpRequest.getContextPath();
		if (requestUrl.startsWith(context + "/a/")) {
			return true;
		}
		return false;
	}

	@Override
	public void destroy() {
		this.filterConfig = null;
	}

	protected void redirect(String url, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (url.startsWith("/")) {
			url = request.getContextPath() + url;
		}
		response.sendRedirect(response.encodeRedirectURL(url));
	}

}
