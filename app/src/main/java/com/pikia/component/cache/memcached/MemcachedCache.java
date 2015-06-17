package com.pikia.component.cache.memcached;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import net.rubyeye.xmemcached.MemcachedClient;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.util.Assert;

public class MemcachedCache implements Cache {
    private static final Object NULL_HOLDER = new NullHolder();
    private final String name;
    private final MemcachedClient memcachedClient; // memcache客户端
    // 是否滿期
    private final int expiry;
    private final boolean allowNullValues;

    public MemcachedCache(String name, MemcachedClient memcachedClient, int expiry) {
	this(name, memcachedClient, expiry, true);
    }

    public MemcachedCache(String name, MemcachedClient memcachedClient, int expiry,
	    boolean allowNullValues) {
	// Assert spring util 验证参数
	Assert.notNull(name, "Name must not be null");
	Assert.notNull(memcachedClient, "MemcachedClient must not be null");
	this.name = name;
	this.memcachedClient = memcachedClient;
	this.expiry = expiry;
	this.allowNullValues = allowNullValues;
    }

    @Override
    public void clear() {

    }

    @Override
    public void evict(Object key) {
	String stringKey = objectToString(key);
	try {
	    this.memcachedClient.delete(stringKey);
	} catch (Exception ex) {
	    throw new IllegalStateException("Failed to delete entry [key=" + stringKey + "]", ex);
	}
    }

    @Override
    public ValueWrapper get(Object key) {
	String stringKey = objectToString(key);
	try {
	    Object value = this.memcachedClient.get(stringKey);
	    return value != null ? new SimpleValueWrapper(fromStoreValue(value)) : null;
	} catch (Exception ex) {
	    throw new IllegalStateException("Failed to get value [key=" + stringKey + "]", ex);
	}
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
	String stringKey = objectToString(key);
	try {
	    Object value = fromStoreValue(this.memcachedClient.get(stringKey));
	    if ((value != null) && (type != null) && (!type.isInstance(value))) {
		throw new IllegalStateException("Cached value is not of required type ["
			+ type.getName() + "]: " + value);
	    }
	    return (T) value;
	} catch (Exception ex) {
	    throw new IllegalStateException("Failed to get value [key=" + stringKey + "]", ex);
	}
    }

    @Override
    public String getName() {
	return this.name;
    }

    @Override
    public Object getNativeCache() {
	return this.memcachedClient;
    }

    @Override
    public void put(Object key, Object value) {
	String stringKey = objectToString(key);
	try {
	    this.memcachedClient.set(stringKey, this.expiry, toStoreValue(value));
	} catch (Exception ex) {
	    throw new IllegalStateException("Failed to set entry [key=" + stringKey + ",expiry="
		    + this.expiry + "(s),value=" + value + "]", ex);
	}
    }

    public final boolean isAllowNullValues() {
	return this.allowNullValues;
    }

    // 值为空的是否,存储自定义的null类
    private static class NullHolder implements Serializable {}

    private static String objectToString(Object object) {
	if (object == null) return null;
	if ((object instanceof String)) {
	    return (String) object;
	}
	return object.toString();
    }

    protected Object toStoreValue(Object userValue) {
	if ((this.allowNullValues) && (userValue == null)) {
	    return NULL_HOLDER;
	}
	return userValue;
    }

    protected Object fromStoreValue(Object storeValue) {
	if ((this.allowNullValues) && (storeValue == NULL_HOLDER)) {
	    return null;
	}
	return storeValue;
    }
}
