package com.pikia.component.message.disruptor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import net.sf.ehcache.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.lmax.disruptor.dsl.Disruptor;

public abstract class AbstractCachingDisruptorFactory extends DisruptorEventFactory implements
	InitializingBean, DisposableBean {
    protected final Log logger = LogFactory.getLog(getClass());
    private final ConcurrentMap<String, Disruptor<DisruptorEvent>> disruptorCache = new ConcurrentHashMap();
    private DisruptorParams disruptorParams;
    private ScheduledExecutorService disruptorRefreshService; // 定时周期执行指定任务的工具类

    public AbstractCachingDisruptorFactory(DisruptorParams disruptorParams) {
	this.disruptorParams = disruptorParams;
    }

    public void setDisruptorParams(DisruptorParams disruptorParams) {
	Assert.notNull(disruptorParams, "disruptorParams must not be null");
	this.disruptorParams = disruptorParams;
	haltAndClearCachedDisruptors();
	enableDisruptorRefreshServiceIfNecessary();
    }

    public DisruptorParams getDisruptorParams() {
	return this.disruptorParams;
    }

    public Disruptor<DisruptorEvent> getDisruptor(String topic) {
	return getDisruptor(topic, null);
    }

    public Disruptor<DisruptorEvent> getDisruptor(String topic, Object owner) {
	String cacheKey = getCacheKey(topic, owner);
	Disruptor disruptor = (Disruptor) this.disruptorCache.get(cacheKey);
	if (disruptor == null) {
	    disruptor = createDisruptor(topic);
	    disruptor.start();
	    // putIfAbsent:key不存在的时候加入一个值,如果key存在就不放入
	    Disruptor cachedDisruptor = (Disruptor) this.disruptorCache.putIfAbsent(cacheKey,
		    disruptor);
	    if (cachedDisruptor != null) {
		disruptor = cachedDisruptor;
	    }

	    if (this.logger.isDebugEnabled()) {
		this.logger.debug("Cached disruptor [" + cacheKey + "->" + disruptor.toString()
			+ ']');
	    }
	}
	return disruptor;
    }

    /**
     * 按key清除缓存
     * 
     * @param topic
     * @return
     */
    public Object removeFromCache(String topic) {
	return removeFromCache(topic, null);
    }

    public Object removeFromCache(String topic, Object owner) {
	String cacheKey = getCacheKey(topic, owner);
	Object cachedDisruptor = this.disruptorCache.remove(cacheKey);
	if (cachedDisruptor == null) {
	    if (this.logger.isDebugEnabled()) {
		this.logger.debug("No cached instance for topic '" + cacheKey + "' was found");
	    }

	} else if (this.logger.isDebugEnabled()) {
	    this.logger.debug("Cache [" + cachedDisruptor + "] for topic " + cacheKey
		    + " has been cleared");
	}

	return cachedDisruptor;
    }

    // ???这里是定义key的名称?不指定的话就默认??
    protected String getCacheKey(String topic, Object owner) {
	return owner != null ? topic + "_" + owner : topic;
    }

    public Map<String, Disruptor<DisruptorEvent>> getCachedDisruptors() {
	// web容器初始化的是否,已经将topic装进这里面了
	return Collections.unmodifiableMap(this.disruptorCache);// 指定映射的不可修改视图,试图对返回的映射进行修改会报异常
    }

    protected abstract Disruptor<DisruptorEvent> createDisruptor(String paramString);

    public Disruptor<DisruptorEvent> newDisruptor() {
	return new Disruptor(this, this.disruptorParams.getInputRingBufferSize(),
		Executors.newCachedThreadPool());
    }

    @Override
    public void destroy() throws Exception {
	haltAndClearCachedDisruptors();
	shutdownAndClearDisruptorRefreshService();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
	enableDisruptorRefreshServiceIfNecessary();
    }

    public void enableDisruptorRefreshServiceIfNecessary() {
	shutdownAndClearDisruptorRefreshService();// 关闭周期定时器
	long inputDisruptorRefreshCycle = this.disruptorParams.getInputDisruptorRefreshCycle();
	if (inputDisruptorRefreshCycle > 0L) {
	    this.disruptorRefreshService = Executors.newScheduledThreadPool(1);
	    Runnable task = new Runnable() {
		public void run() {
		    AbstractCachingDisruptorFactory.this.haltAndClearCachedDisruptors();
		}
	    };
	}
    }

    public void haltAndClearCachedDisruptors() {
	Map<String, Disruptor<DisruptorEvent>> disruptors = new HashMap(this.disruptorCache);
	clearCache();
	for (String topic : disruptors.keySet()) {
	    Disruptor disruptor = (Disruptor) disruptors.get(topic);
	    if (this.logger.isDebugEnabled()) {
		this.logger.debug("Halting disruptor [" + disruptor + "] for topic '" + topic
			+ "'...");
	    }
	    disruptor.halt();
	}
	// ???不是被unmodifiableMap了,怎么还能clear
	disruptors.clear();
    }

    public void shutdownAndClearDisruptorRefreshService() {
	if (this.disruptorRefreshService != null) {
	    if (this.logger.isDebugEnabled()) {
		this.logger.debug("Shutting down and clearing disruptor refresh service ["
			+ this.disruptorRefreshService + "]...");
	    }
	    this.disruptorRefreshService.shutdownNow();
	    this.disruptorRefreshService = null;
	}
    }

    protected void clearCache() {
	if (this.logger.isDebugEnabled()) {
	    this.logger.debug("Clearing entire disruptor cache");
	}
	this.disruptorCache.clear();
    }

}
