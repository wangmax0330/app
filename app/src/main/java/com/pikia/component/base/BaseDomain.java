package com.pikia.component.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseDomain {
    protected final Log logger = LogFactory.getLog(getClass());
    private Long id;
    private boolean delflag = false; // 是否已经删除了
    private boolean modified; // 是否已经被修改过了
    private boolean initialized; // 是否已经初始化了

    public BaseDomain(Long id) {
	this.id = id;
    }

    public BaseDomain() {

    }

    public boolean isDelflag() {
	return delflag;
    }

    public void setDelflag(boolean delflag) {
	this.delflag = delflag;
    }

    public boolean isModified() {
	return modified;
    }

    public void setModified(boolean modified) {
	this.modified = modified;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public boolean isInitialized() {
	return initialized;
    }

    public void setInitialized(boolean initialized) {
	this.initialized = initialized;
    }

}
