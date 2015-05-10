package com.pikia.componet.service;

import java.util.List;

import com.pikia.componet.pagination.PaginationQueryContext;

public abstract interface ModelCrudService extends ModelLister {

	public abstract Object getModel(Long paramLong);

	public abstract Object saveOrUpdate(Object paramObject);

	public abstract void delete(Long[] paramArrayOfLong);

	public abstract void delete(Long paramLong);

	public abstract List getPagedModelIds(PaginationQueryContext queryContext);

	public abstract int getTotalCount(PaginationQueryContext queryContext);
}
