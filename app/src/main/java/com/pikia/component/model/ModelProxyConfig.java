package com.pikia.component.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyConfig;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.adapter.GlobalAdvisorAdapterRegistry;
import org.springframework.aop.support.AopUtils;
import org.springframework.aop.target.SingletonTargetSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

import com.pikia.component.annotation.Introduce;

/**
 * 类似ProxyConfig的功能
 * 
 * @author methew
 * 
 */
@Component
public class ModelProxyConfig extends ProxyConfig implements BeanFactoryAware {
    protected final Log logger = LogFactory.getLog(getClass());
    protected BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    public Object createProxy(Object model) throws BeansException {
	if ((model == null) || (AopUtils.isAopProxy(model)) || (!isAcceptable(model.getClass()))) {
	    return model;
	}
	Object[] interceptors = getAdvicesAndAdvisorsForModel(model.getClass());
	if (this.logger.isDebugEnabled()) {
	    this.logger.debug("Creating proxy for model '" + model.getClass().getName() + "' with "
		    + interceptors.length + " interceptors");
	}
	ProxyFactory proxyFactory = new ProxyFactory();
	proxyFactory.copyFrom(this);
	if (!isProxyTargetClass()) {
	    proxyFactory.setProxyTargetClass(true);
	}
	for (Object interceptor : interceptors) {
	    Advisor advisor = GlobalAdvisorAdapterRegistry.getInstance().wrap(interceptor);
	    proxyFactory.addAdvisor(advisor); // 加入切面
	}
	proxyFactory.setTargetSource(new SingletonTargetSource(model));

	if (!isOptimize()) {
	    proxyFactory.setOptimize(true);
	}
	if (!isFrozen()) {
	    proxyFactory.setFrozen(true);
	}

	return proxyFactory.getProxy();
    }

    protected boolean isAcceptable(Class<?> modelClass) {
	return modelClass.isAnnotationPresent(Introduce.class);
    }

    protected Object[] getAdvicesAndAdvisorsForModel(Class<?> modelClass) {
	Introduce introduceAnnotation = (Introduce) modelClass.getAnnotation(Introduce.class);
	String[] adviceNames = introduceAnnotation.value();
	Object[] advices = new Object[adviceNames.length];
	for (int i = 0; i < adviceNames.length; i++) {
	    advices[i] = this.beanFactory.getBean(adviceNames[i]);
	}
	return advices;
    }
}
