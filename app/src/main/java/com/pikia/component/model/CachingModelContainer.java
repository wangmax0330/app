package com.pikia.component.model;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

public abstract interface CachingModelContainer {
    public abstract void clearModelCache();

    public abstract Cache getModelCache();

    // 调用 Spring 的缓存管理
    public abstract CacheManager getCacheManager();
}
