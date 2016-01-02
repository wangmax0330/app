package com.pikia.blog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.pikia.blog.domain.ApsBlogDomain;
import com.pikia.blog.domain.DateTag;
import com.pikia.blog.repository.ApsBlogRepository;
import com.pikia.blog.service.ApsBlogService;
import com.pikia.component.pagination.PaginationQueryContext;
import com.pikia.component.repository.ModelRepository;
import com.pikia.component.repository.MyBatisRepository;
import com.pikia.component.service.impl.ModelCrudServiceSupport;
import com.pikia.component.web.util.DateUtils;
import com.pikia.component.web.util.JsonUtils;

@Service
public class ApsBlogServiceImpl extends ModelCrudServiceSupport implements ApsBlogService {
	@Resource
	private ApsBlogRepository apsBlogRepository;

	@Override
	public Object get(Long id) {
		if (id == null || id.longValue() == 0)
			return null;
		return this.apsBlogRepository.get(id);
	}

	@Override
	public Object getModel(Long id) {
		if (id == null || id.longValue() == 0)
			return null;
		// CmsRebateDomain domain = (CmsRebateDomain) modelContainer.getModel(
		// ModelUtils.asModelKey(CmsRebateDomain.class, id), domainModelLoader,
		// false);
		// if (domain != null) domain.setInitialized(true);
		ApsBlogDomain domain = (ApsBlogDomain) this.get(id);
		return domain;
	}

	@Override
	public List getPagedModelIds(PaginationQueryContext queryContext) {

		String startDate = queryContext.getRequest().getParameter("startDate");
		String endDate = queryContext.getRequest().getParameter("endDate");
		List<Object> paramLs = new ArrayList<Object>();

		// if (StringUtils.isNotBlank(startDate)) {
		// if (startDate.indexOf(" ") > -1) {
		// startDate = startDate.replaceAll(" ", "%");
		// }
		// paramLs.add("%" + startDate + "%");
		// } else {
		// paramLs.add(null);
		// }
		// if (StringUtils.isNotBlank(endDate)) {
		// if (endDate.indexOf(" ") > -1) {
		// endDate = endDate.replaceAll(" ", "%");
		// }
		// paramLs.add("%" + endDate + "%");
		// } else {
		// paramLs.add(null);
		// }
		if (StringUtils.isNotBlank(startDate)) {
			paramLs.add(startDate + " 00:00:00");
		} else {
			paramLs.add(null);
		}
		if (StringUtils.isNotBlank(endDate)) {
			paramLs.add(endDate + " 23:59:59");
		} else {
			paramLs.add(null);
		}
		queryContext.setParams(paramLs.toArray());
		return this.queryForPaginationList(new MyBatisRepository() {
			public List<Long> queryForPagination(int startIndex, int pageSize, String sortField,
					String sortType, Object... params) {
				return apsBlogRepository.getPagedModelIds(startIndex, pageSize, sortField,
						sortType, (String) params[0], (String) params[1]);
			}
		}, queryContext);
	}

	@Override
	public int getTotalCount(PaginationQueryContext queryContext) {
		String startDate = queryContext.getRequest().getParameter("startDate");
		String endDate = queryContext.getRequest().getParameter("endDate");
		String tag = queryContext.getRequest().getParameter("tag");
		String month = queryContext.getRequest().getParameter("month");
		return apsBlogRepository.getTotalCount(startDate, endDate, tag,month);
	}

	@Override
	protected ModelRepository getModelRepository() {
		return this.apsBlogRepository;
	}

	@Override
	public String getJsonList(List<ApsBlogDomain> blogList) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (ApsBlogDomain tmp : blogList) {
			list.add(getJson(tmp));
		}
		return JsonUtils.JSON_List2String(list);
	}

	private Map<String, Object> getJson(ApsBlogDomain tmp) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			jsonMap.put("id", tmp.getId());
			jsonMap.put("author", tmp.getAuthor());
			jsonMap.put("createTime",
					DateUtils.date2Str(tmp.getCreateTime(), DateUtils.DEFAULT_TIMESTAMP_PATTERN));
			jsonMap.put("title", tmp.getTitle());
			// 内容不需要传过去了
			// jsonMap.put("content", tmp.getContent());
			// jsonMap.put("isPublish", tmp.isPublish());
			jsonMap.put("viewNum", tmp.getViewNum());
			jsonMap.put("publishState", tmp.getPublishState());
			jsonMap.put("version", tmp.getVersion());
			if (tmp.getModifyTimes() > 0) {
				jsonMap.put("modifyTimes", tmp.getModifyTimes());
				jsonMap.put("lastModifyTime", DateUtils.date2Str(tmp.getLastModifyTime(),
						DateUtils.DEFAULT_TIMESTAMP_PATTERN));
				jsonMap.put("versionId", tmp.getVersionId());
			}
			return jsonMap;
		} catch (Exception e) {
			logger.error(e, e);
			return null;
		}
	}

	@Override
	public Object getBlogVersionModel(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ApsBlogDomain> getBlogForWeb(String month, String tag, int startIndex, int pageSize) {
		List<Long> idList = this.apsBlogRepository.getBlogForWeb(month, tag, startIndex, pageSize);
		List<ApsBlogDomain> domainList = new ArrayList<ApsBlogDomain>();
		for (Long id : idList) {
			ApsBlogDomain domain = this.apsBlogRepository.get(id);
			// 不往前台传完整的博客信息
			domain.setContent(null);
			domainList.add(domain);
		}
		return domainList;
	}

	public List<DateTag> getDateForWeb() {
		List<DateTag> dateLis = new ArrayList<DateTag>();
		List<Map> mapLis = this.apsBlogRepository.getDateForWeb();
		for (Map map : mapLis) {
			dateLis.add(new DateTag((String) map.get("date"), (Long) map.get("num")));
		}
		return dateLis;
	}

}
