package com.pikia.component.message.disruptor.consumer;

import java.lang.reflect.Method;

public class ConsumerMethodHolder {
    private String beanName;
    private Method method;

    public ConsumerMethodHolder(String beanName, Method method) {
	this.beanName = beanName;
	this.method = method;
    }

    public String getBeanName() {
	return this.beanName;
    }

    public void setBeanName(String beanName) {
	this.beanName = beanName;
    }

    public Method getMethod() {
	return this.method;
    }

    public void setMethod(Method method) {
	this.method = method;
    }
}
