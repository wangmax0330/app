package com.pikia.component.cache.decorating;

import java.util.Collection;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

public class ValueProcessingCacheManagerDecorator implements CacheManager, InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public Cache getCache(String arg0) {
	return null;
    }

    @Override
    public Collection<String> getCacheNames() {
	return null;
    }

}
