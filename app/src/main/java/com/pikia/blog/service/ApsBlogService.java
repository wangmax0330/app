package com.pikia.blog.service;

import java.util.List;

import com.pikia.blog.domain.ApsBlogDomain;
import com.pikia.component.service.ModelCrudService;

public interface ApsBlogService extends ModelCrudService {
	public Object getModel(Long id);

	public String getJsonList(List<ApsBlogDomain> blogList);

	// -------------------- 关于博客版本的service方法
	public Object getBlogVersionModel(Long id);

}
