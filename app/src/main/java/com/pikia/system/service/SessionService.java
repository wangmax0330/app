package com.pikia.system.service;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.pikia.component.web.controller.SimpleController;

public abstract interface SessionService {
	public abstract <T> T getCurrentUser(HttpServletRequest paramHttpServletRequest,
			Class<T> paramClass);

	public abstract void setCurrentUser(HttpServletRequest paramHttpServletRequest,
			Object paramObject);

	public abstract void setCurrentUserId(HttpServletRequest paramHttpServletRequest, Long paramLong);

	public abstract Long getCurrentUserId(HttpServletRequest paramHttpServletRequest);

	public abstract Locale getCurrentLocal(HttpServletRequest paramHttpServletRequest);

	public abstract void setCurrentLocal(HttpServletRequest paramHttpServletRequest,
			String paramString);

	public abstract void setCurrentUserId(HttpSession session, Long uid);

	public abstract Long getCurrentUserId(HttpSession session);

	public abstract void setCurrentUser(HttpSession session, Object paramObject);
}
