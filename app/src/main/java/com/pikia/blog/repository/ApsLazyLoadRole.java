package com.pikia.blog.repository;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.pikia.component.ddd.message.DomainMessage;

@Component
public class ApsLazyLoadRole implements Serializable {
	
	public Object apsLazyLoadUserEventMessage(Long userId) {
		return null;
	}
	// @Send(value = "apsLazyLoadUser")
	// public DomainMessage apsLazyLoadUserEventMessage(Long userId) {
	// return new DomainMessage(userId);
	// }
}
