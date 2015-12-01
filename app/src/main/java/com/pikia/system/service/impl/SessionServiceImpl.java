package com.pikia.system.service.impl;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.pikia.component.web.util.ConstUtils;
import com.pikia.system.service.SessionService;

@Service
public class SessionServiceImpl implements SessionService {

	@Override
	public <T> T getCurrentUser(HttpServletRequest paramHttpServletRequest, Class<T> paramClass) {
		return null;
	}

	@Override
	public void setCurrentUser(HttpServletRequest paramHttpServletRequest, Object paramObject) {

	}

	@Override
	public void setCurrentUserId(HttpSession session, Long uid) {
		session.setAttribute(ConstUtils.SESSION_USER_ID, uid);
	}

	@Override
	public Long getCurrentUserId(HttpSession session) {
		return null;
		// return (Long) session.getAttribute(ConstUtils.SESSION_USER_ID);
	}

	@Override
	public void setCurrentUserId(HttpServletRequest paramHttpServletRequest, Long paramLong) {

	}

	@Override
	public Long getCurrentUserId(HttpServletRequest paramHttpServletRequest) {
		return null;
	}

	@Override
	public Locale getCurrentLocal(HttpServletRequest paramHttpServletRequest) {
		return null;
	}

	@Override
	public void setCurrentLocal(HttpServletRequest paramHttpServletRequest, String paramString) {

	}

	@Override
	public void setCurrentUser(HttpSession session, Object paramObject) {

	}
}