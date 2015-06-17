package com.pikia.component.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class ModelProxyInjection implements BeanFactoryAware {
    private final Log logger = LogFactory.getLog(getClass());
    private final ConcurrentMap<Class<?>, FieldAndMethodInjection> injectionCache = new ConcurrentHashMap();
    private final ModelProxyConfig modelProxyConfig;
    private BeanFactory beanFactory;

    @Autowired
    public ModelProxyInjection(ModelProxyConfig modelProxyConfig) {
	this.modelProxyConfig = modelProxyConfig;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
	this.beanFactory = beanFactory;
    }

    /**
     * 载入@Resource注入的相关类
     * 
     * @param model
     * @throws BeansException
     */
    public void injectDependencies(Object model) throws BeansException {
	Class modelClass = model.getClass();
	FieldAndMethodInjection injection = this.injectionCache.get(modelClass);
	if (injection == null) {
	    injection = new FieldAndMethodInjection();
	    Class clazz = modelClass;
	    do {
		for (Field field : clazz.getDeclaredFields()) {

		    // @Autowired 注解注入处理
		    if (field.isAnnotationPresent(Autowired.class)) {
			Autowired autowired = (Autowired) field.getAnnotation(Autowired.class);
			String nameRef = "";
			if (field.isAnnotationPresent(Qualifier.class)) {
			    nameRef = ((Qualifier) field.getAnnotation(Qualifier.class)).value()
				    .trim();
			}

			if (injection.fieldInjections == null) {
			    injection.fieldInjections = new HashMap();
			}
			injection.fieldInjections.put(field,
				new DependencyInfo(nameRef, field.getType(), autowired.required()));
		    }
		    // @Resource 注解注入处理
		    if (field.isAnnotationPresent(Resource.class)) {
			Resource resource = (Resource) field.getAnnotation(Resource.class);
			String nameRef = resource.name();

			if (injection.fieldInjections == null) {
			    injection.fieldInjections = new HashMap();
			}
			injection.fieldInjections.put(field,
				new DependencyInfo(nameRef, field.getType(), false));
		    }
		}
		clazz = clazz.getSuperclass(); // 获得父类
	    } while (clazz != Object.class);// Class是Object的直接子类,这里不相当于true?
	}
    }

    /**
     * 清除Map存储的缓存
     */
    public void clearCache() {
	if (this.logger.isDebugEnabled()) {
	    this.logger.debug("Clearing entire injection cache");
	}
	this.injectionCache.clear();
    }

    /**
     * 处理属性注入
     * 
     * @param model
     * @param field
     * @param value
     */
    protected void injectFieldDependency(Object model, Field field, Object value) {
	ReflectionUtils.makeAccessible(field);
	ReflectionUtils.setField(field, model, value);
	if (this.logger.isTraceEnabled())
	    this.logger.trace("Set field " + field.getName() + " on " + model + ", injected ["
		    + value + "]");
    }

    /**
     * 处理方法的注入
     * 
     * @param model
     * @param method
     * @param value
     */
    protected void injectMethodDependency(Object model, Method method, Object value) {
	ReflectionUtils.makeAccessible(method);
	ReflectionUtils.invokeMethod(method, model, new Object[] { value });
	if (this.logger.isTraceEnabled())
	    this.logger.trace("Invoked method " + method.getName() + " on " + model
		    + ", injected [" + value + "]");
    }

    /**
     * Map 存储enhance注入的信息
     * 
     * @author methew
     * 
     */
    static class FieldAndMethodInjection {
	Map<Field, ModelProxyInjection.DependencyInfo> fieldInjections;
	Map<Method, ModelProxyInjection.DependencyInfo> methodInjections;

	boolean isEmpty() {
	    return ((this.fieldInjections == null) || (this.fieldInjections.isEmpty()))
		    && ((this.methodInjections == null) || (this.methodInjections.isEmpty()));
	}

	public String toString() {
	    StringBuffer sb = new StringBuffer("fieldInjections ");
	    if (this.fieldInjections == null) {
		sb.append("null");
	    } else {
		sb.append('{');
		for (Map.Entry entry : this.fieldInjections.entrySet()) {
		    sb.append(((Field) entry.getKey()).getName()).append('=')
			    .append(entry.getValue()).append(',');
		}
		sb.deleteCharAt(sb.length() - 1).append('}');
	    }
	    sb.append("; methodInjections ");
	    if (this.methodInjections == null) {
		sb.append("null");
	    } else {
		sb.append('{');
		for (Map.Entry entry : this.methodInjections.entrySet()) {
		    sb.append(((Method) entry.getKey()).getName()).append('=')
			    .append(entry.getValue()).append(',');
		}
		sb.deleteCharAt(sb.length() - 1).append('}');
	    }
	    return sb.toString();
	}
    }

    /**
     * 依赖注入的信息
     * 
     * @author methew
     * 
     */
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
