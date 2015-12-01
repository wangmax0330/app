package com.pikia.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pikia.blog.domain.ApsUserDomain;
import com.pikia.blog.repository.ApsUserRepository;
import com.pikia.blog.service.ApsUserService;
import com.pikia.component.pagination.PaginationQueryContext;
import com.pikia.component.repository.ModelRepository;
import com.pikia.component.service.impl.ModelCrudServiceSupport;

@Service
public class ApsUserServiceImpl extends ModelCrudServiceSupport implements ApsUserService {
	@Resource
	private ApsUserRepository apsUserRepository;

	@Override
    // Propagation.REQUIRED 如果有事务,那么加入事务,没有的话新建一个(不写的情况下)
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
	public Object get(Long id) {
		if (id == null || id.longValue() == 0) return null;
		return this.apsUserRepository.get(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
	public Object getModel(Long id) {
		if (id == null || id.longValue() == 0) return null;
//		CmsRebateDomain domain = (CmsRebateDomain) modelContainer.getModel(
//				ModelUtils.asModelKey(CmsRebateDomain.class, id), domainModelLoader, false);
//		if (domain != null) domain.setInitialized(true);
		ApsUserDomain domain=(ApsUserDomain) this.get(id);
		return domain;
	}

	@Override
	public List getPagedModelIds(PaginationQueryContext queryContext) {
		return null;
	}

	@Override
	public int getTotalCount(PaginationQueryContext queryContext) {
		return 0;
	}

	@Override
	protected ModelRepository getModelRepository() {
		return this.apsUserRepository;
	}

}
