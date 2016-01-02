package com.pikia.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pikia.blog.domain.ApsTagDomain;
import com.pikia.blog.service.ApsBlogService;
import com.pikia.blog.service.ApsTagService;
import com.pikia.component.service.ModelCrudService;
import com.pikia.component.web.controller.ModelCrudControllerSupport;
import com.pikia.component.web.util.JsonUtils;
import com.pikia.component.web.util.ResponseUtils;
import com.pikia.system.domain.SystemUserDomain;

@Controller
@RequestMapping("/tag")
public class ApsTagController extends ModelCrudControllerSupport {
	protected final Logger logger = Logger.getLogger(ApsTagController.class);

	@Resource
	private ApsTagService apsTagService;
	@Resource
	private ApsBlogService apsBlogService;

	@RequestMapping(value = "/list", method = { RequestMethod.POST, RequestMethod.GET })
	public void tagList(HttpServletRequest request, HttpServletResponse response) {
		try {
			SystemUserDomain user = this.sessionService.getCurrentUser(request,
					SystemUserDomain.class);
			if (user == null || !(user.isAdmin())) {
				ResponseUtils.writeGetJsonErrorMessage(response, "您还没法访问，请联系管理员！", null);
				return;
			}
			String value = request.getParameter("name");
			List<Map> tags = this.apsTagService.getTagByKeyWordInMap(value + "%");
			StringBuffer sb = new StringBuffer();
			int idx = 0;
			for (Object obj : tags) {
				Map good = (Map) obj;
				Map tmp = new HashMap();
				tmp.put("id", good.get("NAME"));
				tmp.put("name", good.get("VALUE"));
				if (idx > 0)
					sb.append(",");
				idx++;
				sb.append(JsonUtils.JSON_Bean2String(tmp));
			}
			ResponseUtils.writeMessage(response, "{\"isSuc\":\"1\",\"rows\":[" + sb + "]}");
		} catch (Exception e) {
			logger.error(e, e);
			ResponseUtils.writeJsonErrorMessage(response, e.getMessage(), null);
		}
	}

	/**
	 * 查询标签库里面的所有标签
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/showAllTag", method = { RequestMethod.POST, RequestMethod.GET })
	public String getAllTag(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<ApsTagDomain> tagDomainList = apsTagService.getAllTags();
			request.setAttribute("tags", tagDomainList);
		} catch (Exception e) {
			logger.error(e, e);
		}
		return "/blog/blog_tag_edit";
	}

	@RequestMapping(value = "/saveTag", method = { RequestMethod.POST, RequestMethod.GET })
	public void saveTagAjax(HttpServletRequest request, HttpServletResponse response) {
		try {
			String newTag = request.getParameter("tag");
			// String[] tagArray = newTags.split(",");
			// List<ApsTagDomain> tagList = new ArrayList<ApsTagDomain>();
			// for (String tag : tagArray) {
			// ApsTagDomain tagDomain = new ApsTagDomain();
			// tagDomain.setName(tag);
			// tagDomain.setValue(tag);
			// tagList.add(tagDomain);
			// }
			// apsTagService.saveOrUpdateForList(tagList);
			SystemUserDomain userDomain = (SystemUserDomain) sessionService.getCurrentUser(request,
					SystemUserDomain.class);
			if (userDomain == null) {
				ResponseUtils.writeGetJsonErrorMessage(response, null, "登录超时,请先重新登录");
				return;
			}
			ApsTagDomain tagDomain = (ApsTagDomain) apsTagService.getTagByNameInDomain(newTag);
			if (tagDomain == null) {
				tagDomain = new ApsTagDomain();
				tagDomain.setName(newTag);
				tagDomain.setValue(newTag);
				apsTagService.saveOrUpdate(tagDomain);
			} else {
				tagDomain.setDelflag(false);
				apsTagService.saveOrUpdate(tagDomain);
			}
			ResponseUtils.writeJsonSuccessMessage(response, "保存成功", "保存成功2");
		} catch (Exception e) {
			logger.error(e, e);
			ResponseUtils.writeGetJsonErrorMessage(response, null, "系统出错");
		} finally {
		}
	}

	@RequestMapping(value = "/delTag", method = { RequestMethod.POST, RequestMethod.GET })
	public void delTagAjax(HttpServletRequest request, HttpServletResponse response) {
		try {
			String tagName = request.getParameter("tag");
			if (StringUtils.isBlank(tagName)) {
				ResponseUtils.writeGetJsonErrorMessage(response, null, "标签读取错误");
				return;
			}
			SystemUserDomain userDomain = (SystemUserDomain) sessionService.getCurrentUser(request,
					SystemUserDomain.class);
			apsTagService.deleteByName(tagName);
			ResponseUtils.writeJsonSuccessMessage(response, "保存成功", "保存成功2");
		} catch (Exception e) {
			logger.error(e, e);
			ResponseUtils.writeGetJsonErrorMessage(response, null, "系统出错");
		} finally {
		}
	}

	@Override
	protected ModelCrudService getModelCrudService() {
		// TODO Auto-generated method stub
		return null;
	}
}
