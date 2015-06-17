package com.pikia.component.cache.decorating;

import java.util.Collection;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

public class ValueProcessingCacheDecorator implements Cache {
    private Cache cache;
    private Collection<ValuePostProcessor> valuePostProcessors;

    public ValueProcessingCacheDecorator(Cache cache,
	    Collection<ValuePostProcessor> valuePostProcessors) {
	this.cache = cache;
	this.valuePostProcessors = valuePostProcessors;
    }

    @Override
    public void clear() {
	this.cache.clear();
    }

    @Override
    public void evict(Object key) {
	this.cache.evict(key);
    }

    @Override
    public ValueWrapper get(Object key) {
	Cache.ValueWrapper valueWrapper = this.cache.get(key);
	Object originalValue = valueWrapper != null ? valueWrapper.get() : null;
	Object value = applyValuePostProcessorsAfterGet(key, originalValue);
	if (value == originalValue) {
	    return valueWrapper;
	}
	return value != null ? new SimpleValueWrapper(value) : null;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
	Object originalValue = this.cache.get(key, type);
	Object value = applyValuePostProcessorsAfterGet(key, originalValue);
	if (value == originalValue) {
	    return (T) originalValue;
	}
	if ((value != null) && (type != null) && (!type.isInstance(value))) {
	    throw new IllegalStateException("Cached value is not of required type ["
		    + type.getName() + "]: " + value);
	}
	return (T) value;
    }

    @Override
    public String getName() {
	return this.cache.getName();
    }

    @Override
    public Object getNativeCache() {
	return this.cache.getNativeCache();
    }

    @Override
    public void put(Object key, Object value) {
	value = applyValuePostProcessorsBeforePut(key, value);
	this.cache.put(key, value);
    }

    // -------------------------------------------------------
    private Object applyValuePostProcessorsAfterGet(Object key, Object value) {
	for (ValuePostProcessor valuePostProcessor : this.valuePostProcessors) {
	    value = valuePostProcessor.postProcessAfterGet(key, value);
	    if (value == null) {
		return value;
	    }
	}
	return value;
    }

    private Object applyValuePostProcessorsBeforePut(Object key, Object value) {
	for (ValuePostProcessor valuePostProcessor : this.valuePostProcessors) {
	    value = valuePostProcessor.postProcessBeforePut(key, value);
	    if (value == null) {
		return value;
	    }
	}
	return value;
    }
}
