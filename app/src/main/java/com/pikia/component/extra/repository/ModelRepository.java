package com.pikia.component.extra.repository;

public abstract interface ModelRepository {

	public abstract Object save(Object paramObject);

	public abstract Object update(Object paramObject);

	public abstract void delete(Long[] paramArrayOfLong);

	public abstract void delete(Long paramLong);
}
