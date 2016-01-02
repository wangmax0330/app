package com.pikia.blog.service;

import java.util.List;
import java.util.Map;

import com.pikia.blog.domain.ApsTagDomain;
import com.pikia.component.service.ModelCrudService;

public interface ApsTagService extends ModelCrudService {
	public Object getModel(Long id);

	public void deleteByName(String tagName);

	public List<ApsTagDomain> getAbstractTagByName(String name);

	public ApsTagDomain getTagByNameInDomain(String name);

	public List<Map> getTagByKeyWordInMap(String key);

	public List<ApsTagDomain> saveOrUpdateForList(List<ApsTagDomain> paramObject);

	public List<ApsTagDomain> getAllTags();

	public String handleBeforeCommit(String oldTags, String newTags);

}
