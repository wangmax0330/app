package com.pikia.component.model.cache;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.pikia.component.cache.decorating.ValuePostProcessorSupport;
import com.pikia.component.model.ModelProxyConfig;

public class ModelAwareValuePostProcessor extends ValuePostProcessorSupport implements
	BeanFactoryAware {
    private final Log logger;
    @Autowired
    private ModelProxyConfig modelProxyConfig;
    private BeanFactory beanFactory;
    private final ConcurrentMap<Class<?>, FieldInjection> injectionCache;
    private boolean recursiveReinject;

    public ModelAwareValuePostProcessor() {
	this.logger = LogFactory.getLog(getClass());
	this.injectionCache = new ConcurrentHashMap();
	this.recursiveReinject = true;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    public void reinjectTransientDependenciesIfNecessary(Object model,
	    Collection<Object> handlingModels) throws BeansException {
	if (this.logger.isDebugEnabled()) {
	    this.logger.debug("Re-injecting transient dependencies for model: " + model);
	}
	Class modelClass = model.getClass();
	FieldInjection injection = (FieldInjection) this.injectionCache.get(modelClass);

	if (injection == null) {
	    injection = new FieldInjection();
	    Class clazz = modelClass;
	}

    }

    protected Object getInjectedObject(Object model, String nameRef, Class<?> injectedType)
	    throws BeansException {
	Object injectedObject = null;
	if (nameRef.equals(""))
	    try {
		injectedObject = this.beanFactory.getBean(injectedType);
	    } catch (NoSuchBeanDefinitionException ex) {
		if (this.logger.isWarnEnabled()) {
		    this.logger
			    .warn("Injected object of type ["
				    + injectedType.getName()
				    + "] not found in bean factory ["
				    + this.beanFactory
				    + "], creating an object for model ["
				    + model
				    + "], recommend to configure it in bean factory in production environment to avoid memory redundancy");
		}

		injectedObject = createObject(injectedType);
	    }
	return null;
    }

    protected Object createObject(Class<?> clazz) throws BeansException {
	return BeanUtils.instantiateClass(clazz);
    }

    public void removeFromCache(Class<?> modelClass) {
	Object cachedInjection = this.injectionCache.remove(modelClass);
	if (cachedInjection == null) {
	    if (this.logger.isDebugEnabled()) {
		this.logger.debug("No cached instance for model class '" + modelClass.getName()
			+ "' was found");
	    }

	} else if (this.logger.isDebugEnabled())
	    this.logger.debug("Cache [" + cachedInjection + "] for model class "
		    + modelClass.getName() + " has been cleared");
    }

    public void clearCache() {
	if (this.logger.isDebugEnabled()) {
	    this.logger.debug("Clearing entire injection cache");
	}
	this.injectionCache.clear();
    }

    static class FieldInjection {
	Map<Field, ModelAwareValuePostProcessor.DependencyInfo> transientFieldInjections;
	Collection<Field> modelReferences;

	boolean isEmpty() {
	    return ((this.transientFieldInjections == null) || (this.transientFieldInjections
		    .isEmpty()))
		    && ((this.modelReferences == null) || (this.modelReferences.isEmpty()));
	}

	public String toString() {
	    StringBuffer sb = new StringBuffer("transientFieldInjections ");
	    if (this.transientFieldInjections == null) {
		sb.append("null");
	    } else {
		sb.append('{');
		for (Map.Entry entry : this.transientFieldInjections.entrySet()) {
		    sb.append(((Field) entry.getKey()).getName()).append('=')
			    .append(entry.getValue()).append(',');
		}
		sb.deleteCharAt(sb.length() - 1).append('}');
	    }
	    sb.append("; modelReferences ");
	    if (this.modelReferences == null) {
		sb.append("null");
	    } else {
		sb.append('{');
		for (Field field : this.modelReferences) {
		    sb.append(field.getName()).append(',');
		}
		sb.deleteCharAt(sb.length() - 1).append('}');
	    }
	    return sb.toString();
	}
    }

    static class DependencyInfo {
	final String nameRef;
	final Class<?> injectedType;
	final boolean required;

	DependencyInfo(String nameRef, Class<?> injectedType, boolean required) {
	    this.nameRef = nameRef;
	    this.injectedType = injectedType;
	    this.required = required;
	}

	public String toString() {
	    return "DependencyInfo('" + this.nameRef + "', " + this.injectedType.getName() + ", "
		    + this.required + ")";
	}
    }
}
