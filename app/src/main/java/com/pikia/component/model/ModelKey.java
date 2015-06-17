package com.pikia.component.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.ObjectUtils;

public class ModelKey {
    protected final Log logger = LogFactory.getLog(getClass());
    private final Class<?> modelClass;
    private final Object identifier;

    public ModelKey(Class<?> modelClass, Object identifier) {
	this.modelClass = modelClass;
	this.identifier = identifier;
    }

    public Class<?> getModelClass() {
	return this.modelClass;
    }

    public Object getIdentifier() {
	return this.identifier;
    }

    public boolean equals(Object other) {
	if (this == other) return true;
	if (!(other instanceof ModelKey)) return false;
	ModelKey otherKey = (ModelKey) other;
	return (ObjectUtils.nullSafeEquals(getModelClass(), otherKey.getModelClass()))
		&& (ObjectUtils.nullSafeEquals(getIdentifier(), otherKey.getIdentifier()));
    }

    public int hashCode() {
	int hashCode = getModelClass() == null ? 0 : getModelClass().hashCode();
	hashCode = 29 * hashCode + (getIdentifier() == null ? 0 : getIdentifier().hashCode());
	logger.error("+++++++++++++++++++++++++++" + hashCode);
	return hashCode;
    }
}
