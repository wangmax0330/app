package com.pikia.blog.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApsTagCache implements InitializingBean, DisposableBean {
	public String[] tagCache;

	@Override
	public void destroy() throws Exception {

	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("执行InitAndDestroySeqBean: postConstruct");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("执行InitAndDestroySeqBean: preDestroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("执行InitAndDestroySeqBean: afterPropertiesSet");
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/chj/spring/bean.xml");
		context.close();
	}
}
