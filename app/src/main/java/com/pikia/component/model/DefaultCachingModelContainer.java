package com.pikia.component.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import com.pikia.component.pagination.MutablePagedList;

@Component
public class DefaultCachingModelContainer extends DefaultModelEnhancer implements
	CachingModelContainer {
    protected final Log logger = LogFactory.getLog(getClass());
    protected CacheManager cacheManager; // Spring 抽象的缓存管理
    protected Cache modelCache;

    @Autowired
    public DefaultCachingModelContainer(ModelProxyInjection modelProxyInjection,
	    ModelProxyConfig modelProxyConfig) {
	super(modelProxyInjection, modelProxyConfig);
	// this.cacheManager = cacheManager;
	System.out.println(cacheManager.getCache("modelCache"));
	this.modelCache = cacheManager.getCache("modelCache");
	if (this.modelCache == null)
	    throw new IllegalStateException(
		    "Model cache named 'modelCache' not configured in cacheManager: "
			    + cacheManager);
    }

    public Object addModel(ModelKey modelKey, Object model, boolean enhance) {
	return addModel(modelKey, model, enhance, true);
    }

    public Object addModel(ModelKey modelKey, Object model, boolean enhance, boolean forceUpdate) {
	if ((modelKey == null) || (modelKey.getIdentifier() == null)) {
	    return null;
	}
	if (!ModelUtils.isModel(model)) {
	    if (this.logger.isDebugEnabled()) {
		this.logger.debug("Object [" + model
			+ "] can not be cached because it is not a model object");
	    }

	    return null;
	}
	if ((forceUpdate) || (!containsModel(modelKey))) {
	    model = enhance ? enhanceModel(model) : model;
	    this.modelCache.put(modelKey.toString(), model);
	    if (this.logger.isDebugEnabled()) {
		this.logger.debug("Cached model [" + model + "] with key [" + modelKey.toString()
			+ "] in cache [" + this.modelCache.getName() + "]");
	    }
	}
	return model;
    }

    public boolean containsModel(ModelKey modelKey) {
	return getModelFromCache(modelKey) != null;
    }

    protected Object getModelFromCache(ModelKey modelKey) {
	Cache.ValueWrapper valueWrapper = this.modelCache.get(modelKey.toString());
	return valueWrapper != null ? valueWrapper.get() : null;
    }

    @Override
    public void clearModelCache() {
	this.modelCache.clear();
    }

    @Override
    public Cache getModelCache() {
	return this.modelCache;
    }

    @Override
    public CacheManager getCacheManager() {
	return this.cacheManager;
    }

    // 把缓存中的model装进List 返回
    public void identifiersToMpdels(MutablePagedList<Object> pagedList, Class<?> modelClass,
	    ModelLoader modelLoader) {
	List identifiers = pagedList.getItems();
	List models = new ArrayList(identifiers.size());
	for (Iterator it = identifiers.iterator(); it.hasNext();) {
	    Object identifier = it.next();
	    Object model = getModel(ModelUtils.asModelKey(modelClass, identifier), modelLoader,
		    true);
	    models.add(model);
	}
    }

    public <T> List<T> identifiersToModels(List<? extends Object> identifiers, Class<T> modelClass,
	    ModelLoader modelLoader) {
	List models = new ArrayList(identifiers.size());
	for (Iterator i$ = identifiers.iterator(); i$.hasNext();) {
	    Object identifier = i$.next();
	    Object model = getModel(ModelUtils.asModelKey(modelClass, identifier), modelLoader,
		    true);
	    models.add(model);
	}
	return models;
    }

    public Object getModel(ModelKey modelKey, ModelLoader modelLoader, boolean required) {
	if ((modelKey == null) || (modelKey.getIdentifier() == null)) {
	    return null;
	}
	if (modelLoader == null) {
	    throw new IllegalArgumentException("Parameter 'modelLoader' must not be null");
	}
	Object model = null;
	model = getModelFromCache(modelKey);
	if (model != null) {
	    if (this.logger.isDebugEnabled()) {
		this.logger.debug("Model [" + model + "] retrieved from cache ["
			+ this.modelCache.getName() + "] by key [" + modelKey.toString() + "]");
	    }

	    if (ModelUtils.isModified(model)) {
		if (this.logger.isInfoEnabled()) {
		    this.logger.info("Model [" + model
			    + "] has been modified, removing it from cache ["
			    + this.modelCache.getName() + "]...");
		}
		removeModel(modelKey);
		model = null;
	    }
	    if (model != null) {
		return model;
	    }
	    model = modelLoader.loadModel(modelKey.getIdentifier());
	    if (model == null) {
		if (required) {
		    throw new IllegalStateException("Model [" + modelKey.getClass().getName() + "("
			    + modelKey.getIdentifier()
			    + ")] returned by model loader must not be null");
		}
		if (this.logger.isInfoEnabled()) {
		    this.logger.info("Model [" + modelKey.getClass().getName() + "("
			    + modelKey.getIdentifier() + ")] can not be loaded by model loader: "
			    + modelLoader);
		}

		return null;
	    }
	    if (!containsModel(modelKey)) {
		model = enhanceModel(model);
		this.modelCache.put(modelKey.toString(), model);
	    }
	    if (this.logger.isDebugEnabled()) {
		this.logger.debug("Cached model [" + model + "] with key [" + modelKey.toString()
			+ "] in cache [" + this.modelCache.getName() + "]");
	    }
	    return model;
	}
	return getModelFromCache(modelKey);
    }

    public Object removeModel(ModelKey modelKey) {
	if ((modelKey == null) || (modelKey.getIdentifier() == null)) {
	    return null;
	}
	if (this.logger.isDebugEnabled()) {
	    this.logger.debug("Removing model with key [" + modelKey.toString() + "] from cache ["
		    + this.modelCache.getName() + "]...");
	}
	Object modelToRemove = getModelFromCache(modelKey);
	this.modelCache.evict(modelKey.toString());
	return modelToRemove;
    }
}
