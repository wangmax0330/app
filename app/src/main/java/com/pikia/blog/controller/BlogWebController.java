package com.pikia.blog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pikia.blog.domain.ApsBlogDomain;
import com.pikia.blog.domain.ApsTagDomain;
import com.pikia.blog.domain.DateTag;
import com.pikia.blog.service.ApsBlogService;
import com.pikia.blog.service.ApsTagService;
import com.pikia.component.pagination.PaginationQueryContext;
import com.pikia.component.pagination.SortPagedList;
import com.pikia.component.web.util.ResponseUtils;

/**
 * 博客访问页面Controller
 * 
 * @author Methew
 * 
 */
@Controller
public class BlogWebController {
	protected final Logger logger = Logger.getLogger(BlogWebController.class);
	@Resource
	private ApsBlogService apsBlogService;

	@Resource
	private ApsTagService apsTagService;

	@RequestMapping(value = "/{path}")
	public String blog(@PathVariable("path") String path, HttpServletRequest request,
			HttpServletResponse response) {
		String month = request.getParameter("month");
		String tag = request.getParameter("tag");
		String startIndexStr = request.getParameter("startIndex");
		String pageSizeStr = request.getParameter("pageSize");
		try {
			int startIndex = 0;
			int pageSize = 20;
			if (StringUtils.isNotBlank(startIndexStr)) {
				startIndex = Integer.parseInt(startIndexStr);
			}
			if (StringUtils.isNotBlank(pageSizeStr)) {
				pageSize = Integer.parseInt(pageSizeStr);
			}
//			List<ApsBlogDomain> domainList = apsBlogService.getBlogForWeb(month, tag, startIndex,
//					pageSize);
//			request.setAttribute("domainList", domainList);
			request.setAttribute("tag", tag);
			request.setAttribute("month", month);
		} catch (Exception e) {
			logger.error(e);
		}
		return "web/" + path;
	}

	@RequestMapping(value = "/getMoreBlog")
	public String tmpl(HttpServletRequest request, HttpServletResponse response) {
		String month = request.getParameter("month");
		String tag = request.getParameter("tag");
		// ------------------分页
		try {
			PaginationQueryContext queryContext = new PaginationQueryContext(request);
			queryContext.setStartIndex((queryContext.getPageIndex() - 1)
					* queryContext.getPageSize());
			queryContext.setPageSize(queryContext.getPageSize());
			SortPagedList<Long> pagedList = (SortPagedList<Long>) apsBlogService.list(queryContext,
					null, null, apsBlogService.getTotalCount(queryContext));
			int currentPage = pagedList.getCurrentPageIndex();
			int previousPage = pagedList.getPreviousPageIndex();
			int nextPage = pagedList.getNextPageIndex();
			int[] pages = pagedList.getCurrentPageIndexes();
			int[] currentPageIndexes = pagedList.getCurrentPageIndexes();
			boolean hasPrevious5Page = pagedList.hasPrevious5Pages();
			boolean hasNext5Page = pagedList.hasNext5Pages();
			int records = pagedList.getTotalItemCount();
			request.setAttribute("currPage", currentPage);
			request.setAttribute("previousPage", previousPage);
			request.setAttribute("pages", pages);
			request.setAttribute("currentPageIndexes", currentPageIndexes);
			request.setAttribute("hasPrevious5Page", hasPrevious5Page);
			request.setAttribute("hasNext5Page", hasNext5Page);
			request.setAttribute("records", records);
			request.setAttribute("nextPage", nextPage);
			// -------------------------
			List<ApsBlogDomain> domainList = apsBlogService.getBlogForWeb(month, tag,
					queryContext.getStartIndex(), queryContext.getPageSize());
			request.setAttribute("domainList", domainList);
		} catch (Exception e) {
			logger.error(e);
		}
		return "web/blog_tmpl";
	}

	@RequestMapping(value = "/getDateSide")
	public String date_side_tmpl(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<DateTag> dateList = apsBlogService.getDateForWeb();
			request.setAttribute("dateList", dateList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return "web/blog_date_side";
	}

	@RequestMapping(value = "/getTagSide")
	public String tag_side_tmpl(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<ApsTagDomain> tagDomainList = apsTagService.getAllTags();
			request.setAttribute("tagList", tagDomainList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return "web/blog_tag_side";
	}

	@RequestMapping(value = "/getBlogPagination", method = { RequestMethod.POST, RequestMethod.GET })
	public void getPaginationBottom(HttpServletRequest request, HttpServletResponse response) {
		try {
			PaginationQueryContext queryContext = new PaginationQueryContext(request);
			queryContext.setStartIndex((queryContext.getPageIndex() - 1)
					* queryContext.getPageSize());
			queryContext.setPageSize(queryContext.getPageSize());
			SortPagedList<Long> pagedList = (SortPagedList<Long>) apsBlogService.list(queryContext,
					null, null, apsBlogService.getTotalCount(queryContext));
			ResponseUtils.writeMessage(response, pagedList.pageDescription(null).toString());
		} catch (Exception e) {
			logger.error(e, e);
			ResponseUtils.writeGetJsonErrorMessage(response, "系统出错", null);
		}
	}

	@RequestMapping(value = "/viewblog/{blogId}", method = { RequestMethod.POST, RequestMethod.GET })
	public String viewBlog(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("blogId") Long blogId) {
		try {
			ApsBlogDomain blogDomain = (ApsBlogDomain) apsBlogService.getModel(blogId);
			if (blogDomain.getPublishState() == 1)
				request.setAttribute("blogDomain", blogDomain);
		} catch (Exception e) {
			logger.error(e, e);
			ResponseUtils.writeGetJsonErrorMessage(response, "系统出错", null);
		}
		return "web/blog_view";
	}
}
