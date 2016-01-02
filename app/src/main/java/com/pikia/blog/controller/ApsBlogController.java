package com.pikia.blog.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.pikia.blog.domain.ApsBlogDomain;
import com.pikia.blog.domain.ApsUserDomain;
import com.pikia.blog.service.ApsBlogService;
import com.pikia.blog.service.ApsTagService;
import com.pikia.blog.service.ApsUserService;
import com.pikia.component.pagination.PaginationQueryContext;
import com.pikia.component.pagination.SortPagedList;
import com.pikia.component.service.ModelCrudService;
import com.pikia.component.web.controller.ModelCrudControllerSupport;
import com.pikia.component.web.service.AppCommonService;
import com.pikia.component.web.service.SessionService;
import com.pikia.component.web.util.ResponseUtils;
import com.pikia.system.domain.SystemUserDomain;

/**
 * 后台博客管理系统
 * 
 * @author Methew
 * 
 */
@Controller
@RequestMapping("/blog")
public class ApsBlogController extends ModelCrudControllerSupport {
	protected final Logger logger = Logger.getLogger(ApsBlogController.class);

	@Resource
	private ApsBlogService apsBlogService;
	@Resource
	private ApsUserService apsUserService;
	@Resource
	private AppCommonService commonService;
	@Resource
	private ApsTagService apsTagService;

	@RequestMapping(value = "/editBlog/{blogId}", method = { RequestMethod.POST, RequestMethod.GET })
	public String editBlog(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("blogId") Long blogId) {
		try {
			String uid = request.getParameter("uid");
			ApsBlogDomain blogDomain = null;
			if (blogId.intValue() != 0) {
				blogDomain = (ApsBlogDomain) apsBlogService.getModel(blogId);
			} else {
				blogDomain = new ApsBlogDomain();
			}
			request.setAttribute("blogDomain", blogDomain);
		} catch (Exception e) {
			logger.error(e, e);
			ResponseUtils.writeGetJsonErrorMessage(response, "系统出错", null);
		}
		return "/blog/blog_edit";
	}

	@RequestMapping(value = "/saveBlog", method = { RequestMethod.POST, RequestMethod.GET })
	public void saveBlogAjax(HttpServletRequest request, HttpServletResponse response) {
		try {
			String blogId = request.getParameter("bid");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String publishState = request.getParameter("publishState");
			String simpleContent = "";
			String newTags = request.getParameter("tagIds");
			if (StringUtils.isNotBlank(content)) {

			}
			if (StringUtils.isBlank(title)) {
				ResponseUtils.writeMessage(response, "{\"s\":\"0\"}");
				return;
			}
			SystemUserDomain userDomain = (SystemUserDomain) sessionService.getCurrentUser(request,
					SystemUserDomain.class);

			ApsBlogDomain blogDomain = null;
			if (StringUtils.isNotBlank(blogId) && !blogId.equals("0")) {
				blogDomain = (ApsBlogDomain) this.apsBlogService.getModel(Long.parseLong(blogId));
				blogDomain.setLastModifyTime(new Date());
				blogDomain.setModifyTimes(blogDomain.getModifyTimes() + 1);
				blogDomain.setTags(apsTagService.handleBeforeCommit(blogDomain.getTags(), newTags));
			} else {
				blogDomain = new ApsBlogDomain();
				blogDomain.setCreateTime(new Date());
				blogDomain.setAuthor(userDomain);
				blogDomain.setModifyTimes(0);
				blogDomain.setTags(newTags);
			}
			// 根据hr 分隔符提取文摘摘要
			int separtion = content.indexOf("<hr />");
			if (separtion > -1)
				blogDomain.setSimpleContent(content.substring(0, separtion));
			else {
				int length = content.length();
				if (length > 400) {
					blogDomain.setSimpleContent(content.substring(0, 400));
				} else {
					blogDomain.setSimpleContent(content.substring(0, length));
				}
			}

			blogDomain.setPublishState(Integer.parseInt(publishState));
			blogDomain.setTitle(title);
			blogDomain.setContent(content);
			apsBlogService.saveOrUpdate(blogDomain);
			ResponseUtils.writeJsonSuccessMessage(response, "保存成功", "保存成功2");
			;
		} catch (Exception e) {
			logger.error(e, e);
			ResponseUtils.writeGetJsonErrorMessage(response, null, "系统出错");
		} finally {
		}
	}

	@RequestMapping(value = "/blogList", method = { RequestMethod.POST, RequestMethod.GET })
	public String blogList(HttpServletRequest request, HttpServletResponse response) {
		try {
			// String uid = request.getParameter("uid");
			// ApsBlogDomain blogDomain = (ApsBlogDomain)
			// apsBlogService.getModel(blogId);
			// request.setAttribute("bolgDomain", blogDomain);
			SystemUserDomain userDomain = (SystemUserDomain) sessionService.getCurrentUser(request,
					SystemUserDomain.class);

		} catch (Exception e) {
			logger.error(e, e);
			ResponseUtils.writeGetJsonErrorMessage(response, "系统出错", null);
		}
		return "/blog/blog_list";
	}

	@RequestMapping(value = "/getMoreBlogs", method = { RequestMethod.POST, RequestMethod.GET })
	public void blogListAjax(HttpServletRequest request, HttpServletResponse response) {
		try {
			// String uid = request.getParameter("uid");
			SystemUserDomain userDomain = (SystemUserDomain) sessionService.getCurrentUser(request,
					SystemUserDomain.class);
			PaginationQueryContext queryContext = new PaginationQueryContext(request);
			queryContext.setStartIndex((queryContext.getPageIndex() - 1)
					* queryContext.getPageSize());
			queryContext.setPageSize(queryContext.getPageSize());
			SortPagedList<ApsBlogDomain> pagedList = (SortPagedList<ApsBlogDomain>) apsBlogService
					.list(queryContext, ApsBlogDomain.class,
							apsBlogService.getPagedModelIds(queryContext),
							apsBlogService.getTotalCount(queryContext));
			List<ApsBlogDomain> list = pagedList.getItems();
			ResponseUtils.writeMessage(response,
					pagedList.pageDescription(apsBlogService.getJsonList(list)).toString());
		} catch (Exception e) {
			logger.error(e, e);
			ResponseUtils.writeGetJsonErrorMessage(response, "系统出错", null);
		}
	}

	@RequestMapping(value = "/pic/upload", method = { RequestMethod.POST, RequestMethod.GET })
	public void uploadPic(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			String thume = request.getParameter("thume");
			if (StringUtils.isBlank(thume)) thume = "XL,M,MXL";
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> files = multipartRequest.getFileMap();
			CommonsMultipartFile file = (CommonsMultipartFile) files.get("Filedata");
			// File imgFile = ctx.image("imgFile");
			String picUrl = commonService.uploadFile(file, "blog", false, thume, false);
			ResponseUtils.writeJsonSuccessMessage(response, picUrl, null);
		} catch (Exception e) {
			logger.error(e, e);
			e.printStackTrace();
			ResponseUtils.writeJsonErrorMessage(response, e.getMessage(), null);
		}
	}

	/**
	 * 博客预览
	 * 
	 * @param request
	 * @param response
	 * @param blogId
	 * @return
	 */
	@RequestMapping(value = "/viewblog/{blogId}", method = { RequestMethod.POST, RequestMethod.GET })
	public String viewBlog(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("blogId") Long blogId) {
		try {
			String uid = request.getParameter("uid");
			ApsBlogDomain blogDomain = (ApsBlogDomain) apsBlogService.getModel(blogId);
			request.setAttribute("blogDomain", blogDomain);
		} catch (Exception e) {
			logger.error(e, e);
			ResponseUtils.writeGetJsonErrorMessage(response, "系统出错", null);
		}
		return "/blog/blog_view";
	}

	@Override
	protected ModelCrudService getModelCrudService() {
		return null;
	}
}
