package com.pikia.aps.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pikia.aps.domain.ApsUserDomain;
import com.pikia.aps.service.ApsUserService;
import com.pikia.component.pagination.PaginationQueryContext;
import com.pikia.component.pagination.SortPagedList;
import com.pikia.component.web.util.ResponseUtils;

@Controller
public class ApsUserController {
    protected final Logger logger = Logger.getLogger(ApsUserController.class);
    @Resource
    private ApsUserService apsUserService;

    @RequestMapping(value = "/a-admin/users/list", method = { RequestMethod.POST, RequestMethod.GET })
    public void adminIndexPage(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	PaginationQueryContext queryContext = new PaginationQueryContext(request);
	queryContext.setStartIndex((queryContext.getPageIndex() - 1) * queryContext.getPageSize());
	queryContext.setPageSize(queryContext.getPageSize());

	System.out.println("SIze:  " + apsUserService.getPagedModelIds(queryContext).size());
	System.out.println("Total:   " + apsUserService.getTotalCount(queryContext));
	SortPagedList<ApsUserDomain> pagedList = (SortPagedList<ApsUserDomain>) apsUserService
		.list(queryContext, ApsUserDomain.class,
			apsUserService.getPagedModelIds(queryContext),
			apsUserService.getTotalCount(queryContext));
	List<ApsUserDomain> list = pagedList.getItems();
	ResponseUtils.writeMessage(response,
		pagedList.pageDescription(apsUserService.getJsonList(list)).toString());
    }

    @RequestMapping(value = "/d-front/logout", method = { RequestMethod.POST, RequestMethod.GET })
    public String logout(HttpServletRequest request, HttpServletResponse response,
	    ApsUserDomain user) {
	try {
	    // ApsUserDomain sessionUser = this.sessionService.getCurrentUser(
	    // request, ApsUserDomain.class);
	    // if (sessionUser == null)
	    return "/login";
	    // eventMessageFirer.fireDisruptorEvent(
	    // "lazyCreateLogs",
	    // new DomainMessage(new ApsLogDomain(sessionUser,
	    // "用户退出登录",
	    // ApsLogDomain.LOG_TYPE_LOGOUT ,
	    // sessionUser.getId().toString(),
	    // ApsUserDomain.class.getName()))
	    // );
	} catch (Exception e) {
	    logger.error(e, e);
	}
	return "/login";
    }
}
