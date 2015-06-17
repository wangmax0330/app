package com.pikia.component.cache.memcached;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import net.rubyeye.xmemcached.MemcachedClient;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.util.Assert;

public class MemcachedCacheManager implements CacheManager, InitializingBean {
    private final ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap(16);
    private MemcachedClient memcachedClient;
    private boolean dynamic = true;

    private int expiry = 3600;
    private boolean allowNullValues = true;

    @Override
    public void afterPropertiesSet() throws Exception {
	Assert.notNull(this.memcachedClient, "MemcachedClient must not be null.");
    }

    public MemcachedCacheManager(String[] cacheNames) {
	setCacheNames(Arrays.asList(cacheNames));
    }

    public void setCacheNames(Collection<String> cacheNames) {
	if (cacheNames != null) {
	    for (String name : cacheNames) {
		this.cacheMap.put(name, createMemcachedCache(name));
	    }
	    this.dynamic = false;
	}
    }

    public Collection<String> getCacheNames() {
	// 返回一个没有修改的Set集合
	return Collections.unmodifiableSet(this.cacheMap.keySet());
    }

    protected Cache createMemcachedCache(String name) {
	return new MemcachedCache(name, this.memcachedClient, this.expiry, isAllowNullValues());

    }

    public boolean isAllowNullValues() {
	return this.allowNullValues;
    }

    @Override
    public Cache getCache(String name) {
	Cache cache = (Cache) this.cacheMap.get(name);
	if ((cache == null && (this.dynamic))) {
	    synchronized (this.cacheMap) {
		cache = (Cache) this.cacheMap.get(name);
		if (cache == null) {
		    cache = createMemcachedCache(name);
		    this.cacheMap.put(name, cache);
		}
	    }
	}
	return cache;
    }

}
