package com.pikia.blog.service;

import java.util.List;

import com.pikia.blog.domain.ApsBlogDomain;
import com.pikia.blog.domain.DateTag;
import com.pikia.component.service.ModelCrudService;

public interface ApsBlogService extends ModelCrudService {
	public Object getModel(Long id);

	public String getJsonList(List<ApsBlogDomain> blogList);

	// -------------------- 关于博客版本的service方法
	public Object getBlogVersionModel(Long id);

	// ----------------------------|| 博客页面显示
	public List<ApsBlogDomain> getBlogForWeb(String month, String tag, int startIndex, int pageSize);

	public List<DateTag> getDateForWeb();

	

}
