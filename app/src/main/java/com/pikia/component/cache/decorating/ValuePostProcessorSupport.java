package com.pikia.component.cache.decorating;

import java.util.Collection;

import org.springframework.util.CollectionUtils;

public class ValuePostProcessorSupport implements ValuePostProcessor {

    private Collection<String> supportedCacheNames;

    /**
     * 支持的cache类型
     */
    @Override
    public boolean supportsCacheName(String cacheName) {
	if (this.supportedCacheNames == null) {
	    return true;
	}
	return CollectionUtils.contains(this.supportedCacheNames.iterator(), cacheName);
    }

    @Override
    public Object postProcessAfterGet(Object key, Object value) {
	return value;
    }

    @Override
    public Object postProcessBeforePut(Object key, Object value) {
	return value;
    }

    public Collection<String> getSupportedCacheNames() {
	return supportedCacheNames;
    }

    public void setSupportedCacheNames(Collection<String> supportedCacheNames) {
	this.supportedCacheNames = supportedCacheNames;
    }

}
