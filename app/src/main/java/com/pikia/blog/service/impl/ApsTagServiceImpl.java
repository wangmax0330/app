package com.pikia.blog.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pikia.blog.domain.ApsTagDomain;
import com.pikia.blog.repository.ApsTagRepository;
import com.pikia.blog.service.ApsTagService;
import com.pikia.component.controller.ModelCrudOperator;
import com.pikia.component.model.ModelContainer;
import com.pikia.component.model.ModelLoader;
import com.pikia.component.pagination.PaginationQueryContext;
import com.pikia.component.repository.ModelRepository;
import com.pikia.component.service.impl.ModelCrudServiceSupport;

@Service
public class ApsTagServiceImpl extends ModelCrudServiceSupport implements ApsTagService {

	@Resource
	private ApsTagRepository apsTagRepository;

	@Resource
	private ModelContainer modelContainer;

	@Override
	public Object get(Long id) {
		if (id == null || id.longValue() == 0)
			return null;
		return this.apsTagRepository.get(id);
	}

	@Override
	public List getPagedModelIds(PaginationQueryContext queryContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalCount(PaginationQueryContext queryContext) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getModel(Long id) {
		if (id == null || id.longValue() == 0)
			return null;
		// CmsRebateDomain domain = (CmsRebateDomain) modelContainer.getModel(
		// ModelUtils.asModelKey(CmsRebateDomain.class, id), domainModelLoader,
		// false);
		// if (domain != null) domain.setInitialized(true);
		ApsTagDomain domain = (ApsTagDomain) this.get(id);
		return domain;
	}

	@Override
	protected ModelRepository getModelRepository() {
		// TODO Auto-generated method stub
		return this.apsTagRepository;
	}

	@Override
	public List<ApsTagDomain> getAbstractTagByName(String name) {
		List<Long> idList = this.apsTagRepository.getAbstractTagByName(name);
		List<ApsTagDomain> domainList = new ArrayList<ApsTagDomain>();
		for (Long id : idList) {
			ApsTagDomain domain = this.apsTagRepository.get(id);
			domainList.add(domain);
		}
		return domainList;
	}

	@Override
	public ApsTagDomain getTagByNameInDomain(String name) {
		List<Long> idList = this.apsTagRepository.getTagByName(name);
		ApsTagDomain domain = null;
		int size = idList.size();
		if (size > 1) {
			Long id = Collections.min(idList);
			for (Long idt : idList) {
				if (idt.intValue() != id.intValue())
					this.apsTagRepository.delete(idt);
			}
			domain = this.apsTagRepository.get(idList.get(0));
		} else if (size > 0) {
			domain = this.apsTagRepository.get(idList.get(0));
		}
		return domain;
	}

	@Override
	public List<Map> getTagByKeyWordInMap(String key) {
		List<Map> domainList = this.apsTagRepository.getTagByValueInMap(key);
		return domainList;
	}

	@Override
	public List<ApsTagDomain> saveOrUpdateForList(List<ApsTagDomain> taggDomainList) {
		for (ApsTagDomain tagDomain : taggDomainList) {
			this.apsTagRepository.save(tagDomain);
		}
		return null;
	}

	@Override
	public List<ApsTagDomain> getAllTags() {
		List<Long> tagIds = this.apsTagRepository.getAllTags();
		List<ApsTagDomain> tagDomainList = new ArrayList<ApsTagDomain>();
		tagDomainList = modelContainer.identifiersToModels(tagIds, ApsTagDomain.class,
				new ModelLoader() {
					public Object loadModel(Object id) {
						return get((Long) id);
					}
				});
		return tagDomainList;
	}

	@Override
	public String handleBeforeCommit(String oldTags, String newTags) {
		/**
		 * 异步处理标签的个数,未实现
		 */
		return newTags;
	}

	@Override
	public void deleteByName(String tagName) {
		this.apsTagRepository.deleteByName(tagName);
	}
}