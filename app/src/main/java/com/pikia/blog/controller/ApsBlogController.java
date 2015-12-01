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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.pikia.blog.domain.ApsBlogDomain;
import com.pikia.blog.domain.ApsUserDomain;
import com.pikia.blog.service.ApsBlogService;
import com.pikia.blog.service.ApsUserService;
import com.pikia.component.pagination.PaginationQueryContext;
import com.pikia.component.pagination.SortPagedList;
import com.pikia.component.web.util.ResponseUtils;
import com.pikia.system.service.AppCommonService;

@Controller
@RequestMapping("/blog")
public class ApsBlogController {
	protected final Logger logger = Logger.getLogger(ApsBlogController.class);

	@Resource
	private ApsBlogService apsBlogService;
	@Resource
	private ApsUserService apsUserService;
	@Resource
	private AppCommonService commonService;

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
		return "/plugin/blog/blog_edit";
	}

	@RequestMapping(value = "/saveBlog", method = { RequestMethod.POST, RequestMethod.GET })
	public void saveBlogAjax(HttpServletRequest request, HttpServletResponse response,
			ApsBlogDomain domain) {
		try {
			String uid = request.getParameter("uid");
			// String title = request.getParameter("title");
			// String content = request.getParameter("content");
			String publishState = request.getParameter("publishState");

			// if (StringUtils.isBlank(title)) {
			// ResponseUtils.writeMessage(response, "{\"s\":\"0\"}");
			// return;
			// }
			ApsUserDomain userDomain = (ApsUserDomain) apsUserService.getModel(Long.parseLong(uid));

			ApsBlogDomain blogDomain = null;
			if (domain.getId() != null && domain.getId() != 0) {
				blogDomain = (ApsBlogDomain) this.apsBlogService.getModel(domain.getId());
			}
			blogDomain.setAuthor(userDomain);
			blogDomain.setCreateTime(new Date());
			blogDomain.setPublishState(Integer.parseInt(publishState));
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
		} catch (Exception e) {
			logger.error(e, e);
			ResponseUtils.writeGetJsonErrorMessage(response, "系统出错", null);
		}
		return "/plugin/blog/blog_list";
	}

	@RequestMapping(value = "/getMoreBlogs", method = { RequestMethod.POST, RequestMethod.GET })
	public void blogListAjax(HttpServletRequest request, HttpServletResponse response) {
		try {
			// String uid = request.getParameter("uid");
			String uid = "1";
			PaginationQueryContext queryContext = new PaginationQueryContext(request);
			queryContext.setStartIndex((queryContext.getPageIndex() - 1)
					* queryContext.getPageSize());
			queryContext.setPageSize(queryContext.getPageSize());
			System.out.println(apsBlogService.getPagedModelIds(queryContext));
			System.out.println(apsBlogService.getTotalCount(queryContext));
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
			String picUrl = commonService.uploadFile(file, "coupons", false, thume, false);
			ResponseUtils.writeJsonSuccessMessage(response, picUrl, null);
		} catch (Exception e) {
			logger.error(e, e);
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
			request.setAttribute("bolgDomain", blogDomain);
		} catch (Exception e) {
			logger.error(e, e);
			ResponseUtils.writeGetJsonErrorMessage(response, "系统出错", null);
		}
		return "/plugin/blog/blog_view";
	}
}
