package com.pikia.component.model;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultModelEnhancer implements ModelEnhancer {
    protected final ModelProxyInjection modelProxyInjection;
    protected final ModelProxyConfig modelProxyConfig;

    // @Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除
    // set,get方法
    @Autowired
    public DefaultModelEnhancer(ModelProxyInjection modelProxyInjection,
	    ModelProxyConfig modelProxyConfig) {
	this.modelProxyInjection = modelProxyInjection;
	this.modelProxyConfig = modelProxyConfig;
    }

    @Override
    public <T> T makeModel(Class<T> modelClass) throws BeansException {
	Object modelObject = BeanUtils.instantiateClass(modelClass);
	return (T) enhanceModel(modelObject);
    }

    @Override
    public <T> T enhanceModel(T model) throws BeansException {
	this.modelProxyInjection.injectDependencies(model);
	return (T) this.modelProxyConfig.createProxy(model);
    }

    @Override
    public void injectDependencies(Object model) throws BeansException {
	this.modelProxyInjection.injectDependencies(model);
    }

}
