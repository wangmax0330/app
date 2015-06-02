package com.pikia.component.autoproxy;

import org.apache.log4j.Logger;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.BeansException;

import com.pikia.component.annotation.Introduce;

public class IntroduceAutoProxyCreator extends AbstractAutoProxyCreator {

	protected final Logger logger = Logger
			.getLogger(IntroduceAutoProxyCreator.class);

	@Override
	protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass,
			String beanName, TargetSource customTargetSource)
			throws BeansException {
		if (beanClass.isAnnotationPresent(Introduce.class)) {
			Introduce introduceAnnotation = (Introduce) beanClass
					.getAnnotation(Introduce.class);
			String[] adviceNames = introduceAnnotation.value();
			Object[] advices = new Object[adviceNames.length];
			for (int i = 0; i < adviceNames.length; i++) {
				advices[i] = getBeanFactory().getBean(adviceNames[i]);
			}
			return advices;
		}
		return DO_NOT_PROXY;// return null;
	}

	public String toString() {
		logger.info("-----------------IntroduceAutoProxyCreator    toString(");
		StringBuffer sb = new StringBuffer();
		sb.append(getClass().getSimpleName()).append(" [");
		sb.append(super.toString());
		sb.append("]");
		return sb.toString();
	}
}
